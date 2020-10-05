package com.twc.javaBasic;

public interface Person {
    default String getName() {
        return "Person";
    }
}
