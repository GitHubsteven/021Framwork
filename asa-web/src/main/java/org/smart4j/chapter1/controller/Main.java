package org.smart4j.chapter1.controller;


import org.asa.framewrok.annotation.Aspect;
import org.asa.framewrok.helper.AopHelper;
import org.asa.framewrok.helper.ClassHelper;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/1
 * @Time: 15:41
 * @Description:
 * @version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Set<Class<?>> aspectSet = ClassHelper.getClassSetByAnnotation(Aspect.class);
        for (Class<?> aspect : aspectSet) {
            System.out.println(aspect.getName());
        }
        AopHelper.test();
    }
}