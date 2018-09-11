package chain;

import org.asa.framewrok.annotation.Aspect;
import org.asa.framewrok.annotation.Controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/10
 * @Time: 16:47
 * @Description:
 * @version: 1.0.0
 */
@Aspect(Controller.class)
public class ControllerAspect extends AAspectProxy {
}