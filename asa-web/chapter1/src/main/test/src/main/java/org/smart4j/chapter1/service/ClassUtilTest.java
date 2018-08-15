package org.smart4j.chapter1.service;

import org.junit.Test;
import org.asa.framewrok.util.ClassUtil;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/15
 * @Time: 17:16
 * @Description:
 * @version: 1.0.0
 */
public class ClassUtilTest {

    @Test
    public void getClassTest() throws Exception{
        Set<Class<?>> classSet = ClassUtil.getClassSet("org/asa/framewrok/util");
        for (Class<?> aClass : classSet) {
            System.out.println(aClass.getName());
        }
    }
}