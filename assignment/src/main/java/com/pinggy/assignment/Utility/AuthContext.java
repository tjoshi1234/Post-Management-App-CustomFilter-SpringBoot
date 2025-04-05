package com.pinggy.assignment.Utility;


public class AuthContext {

    private static final ThreadLocal<String> authHeader = new ThreadLocal<>();

    public static void setAuthHeader(String variable){
            authHeader.set(variable);
    }

    public static String getAuthHeader(){
        return authHeader.get();
    }

    public static void clear() {
        authHeader.remove(); // Prevent memory leaks
    }
}
