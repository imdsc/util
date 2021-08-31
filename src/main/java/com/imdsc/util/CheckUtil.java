package com.imdsc.util;

public class CheckUtil {

    public static void notNull(String parameterName, Object obj) {
        if(parameterName==null){
            parameterName = "unknown";
        }
        if(obj==null) {
            throw new IllegalArgumentException(parameterName + " cannot be null");
        }
    }
}
