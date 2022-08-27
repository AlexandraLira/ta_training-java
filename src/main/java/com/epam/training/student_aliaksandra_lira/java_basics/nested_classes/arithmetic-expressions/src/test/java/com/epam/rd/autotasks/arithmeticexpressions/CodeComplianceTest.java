package com.epam.rd.autotasks.arithmeticexpressions;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.visitor.filter.AbstractFilter;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CodeComplianceTest {

    private static CtPackage spoonRootPackage;

    @BeforeAll
    static void init() {
        final SpoonAPI spoon = new Launcher();
        spoon.addInputResource("src/main/java/");
        spoon.buildModel();
        spoonRootPackage = spoon.getFactory().Package().getRootPackage();
    }

    @Test
    void testClasses() {

        Map<String, CtClass> nonAnonClasses = spoonRootPackage.getElements(new AbstractFilter<CtClass>() {
            @Override
            public boolean matches(final CtClass aClass) {
                return !aClass.isAnonymous() && !aClass.isInterface();
            }
        }).stream().collect(Collectors.toMap(
                CtClass::getQualifiedName,
                c -> c
        ));

        assertEquals(2, nonAnonClasses.size(),
                "You must not add any more non-anonymous classes");

        CtClass expressionsClass = nonAnonClasses.get("com.epam.rd.autotasks.arithmeticexpressions.Expressions");
        CtClass variableClass = nonAnonClasses.get("com.epam.rd.autotasks.arithmeticexpressions.Variable");

        assertNotNull(expressionsClass);
        assertNotNull(variableClass);
    }
}
