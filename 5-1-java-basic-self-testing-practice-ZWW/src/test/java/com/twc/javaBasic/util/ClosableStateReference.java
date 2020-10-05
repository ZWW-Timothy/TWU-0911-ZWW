package com.twc.javaBasic.util;

public class ClosableStateReference {
    private boolean isClosed;

    public boolean isClosed() {
        return isClosed;
    }

    public void close() {
        isClosed = true;
    }
}

