package constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/4
 * @Time: 21:19
 * @Description:
 * @version: 1.0.0
 */
public interface ConfigConstant {
    String CONFIG_FILE = "asa_web.properties";

    interface Jdbc {
        String jdbc_driver = "";
        String jdbc_url = "";
    }
}