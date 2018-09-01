package org.asa.framewrok;

import org.asa.framewrok.bean.Data;
import org.asa.framewrok.bean.Handler;
import org.asa.framewrok.bean.Param;
import org.asa.framewrok.bean.View;
import org.asa.framewrok.helper.*;
import org.asa.framewrok.util.*;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 13:45
 * @Description: loadOnStartup = 0
 * @version: 1.0.0
 */
@WebServlet(urlPatterns = "/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //initialize helper classes
        HelperLoader.init();
        //obtain servletContext object(for servlet register)
        ServletContext servletContext = config.getServletContext();
        //register servlet to handle jsp
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //register servlet to handle static resources
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        //obtain action handler
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            //obtain controller and Bean instance
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            HashMap<String, Object> paramMap = new HashMap<>();
            //obtain request paramNames
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }

            //obtain what? request url?
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                String[] params = StringUtil.splitString(body, "&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = StringUtil.splitString(param, "=");
                        if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            Param param;
            if (UploadHelper.isMultipart(req)) {
                param = UploadHelper.createParam(req);
            } else {
                param = RequestHelper.createParam(req);
            }

            //call action method
            Method actionMethod = handler.getActionMethod();
            Object result;
            //避免强制需要参数
            if (param.isEmpty()) {
                result = ReflectionUtil.invoke(controllerBean, actionMethod);
            } else {
                result = ReflectionUtil.invoke(controllerBean, actionMethod, param);
            }

            if (result instanceof View) {
                //return jsp page
                View view = (View) result;
                String path = view.getPath();
                if (StringUtil.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath() + path);
                    } else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            req.setAttribute(entry.getKey(), entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path)
                                .forward(req, resp);
                    }
                }
            } else if (result instanceof Data) {
                //return json data
                Data data = (Data) result;
                Object model = data.getModel();
                if (model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        } else {
            //todo ,找不到的请求
//            doGet(req, resp);
        }
    }

}