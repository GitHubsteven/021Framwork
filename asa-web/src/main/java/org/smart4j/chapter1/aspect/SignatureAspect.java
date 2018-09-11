package org.smart4j.chapter1.aspect;

import org.asa.framewrok.annotation.Aspect;
import org.asa.framewrok.annotation.Controller;
import org.asa.framewrok.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/11
 * @Time: 15:18
 * @Description:
 * @version: 1.0.0
 */
@Aspect(Controller.class)
public class SignatureAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private static final String operator = "asa.xie";

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        String name = method.getName();
        if (name.contains("index")) {
            LOGGER.debug("---------- begin signature ----------");
            LOGGER.debug(String.format("I am from: %s", operator));
        }
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        String name = method.getName();
        if (name.contains("index")) {
            LOGGER.debug(String.format("I leave from : %s", operator));
            LOGGER.debug("----------- end signature-----------");
        }
    }
}