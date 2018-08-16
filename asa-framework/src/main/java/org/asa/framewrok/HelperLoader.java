package org.asa.framewrok;

import org.asa.framewrok.helper.BeanHelper;
import org.asa.framewrok.helper.ClassHelper;
import org.asa.framewrok.helper.ControllerHelper;
import org.asa.framewrok.helper.IocHelper;
import org.asa.framewrok.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author huangyong
 * @since 1.0.0
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
//            AopHelper.class,              todo release this comment
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}