package com.twc.javaBasic.util;

public interface InterfaceExtendsInterfaceWithDefaultMethod extends InterfaceWithDefaultMethod {
    @Override
    default String getTheTruthOfTheUniverse() {
        return "Food";
    }
}
