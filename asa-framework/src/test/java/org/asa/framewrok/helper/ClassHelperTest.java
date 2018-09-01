package org.asa.framewrok.helper;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ClassHelperTest {
    @Test
    public void getClassFromPackageTest() {
        Set<Class<?>> classSet = ClassHelper.getClassSet();
        System.out.println(classSet.size());
    }
}