package org.asa.framewrok.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 9:43
 * @Description: 实例化对象
 * @version: 1.0.0
 */
public class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 创建实例（根据类名）
     */
    public static Object newInstance(String className) {
        Class<?> aClass = ClassUtil.loadClass(className);
        return newInstance(aClass);
    }

    /**
     * 调用方法, to understand: how does spring to manage method invoke
     */
    public static Object invoke(Object conductor, Method method, Object... params) {
        method.setAccessible(true);
        try {
            return method.invoke(conductor, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置成员变量的值
     *
     * @param obj   the object whose field should be modified
     * @param field field in Obj
     * @param value field value
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }
}