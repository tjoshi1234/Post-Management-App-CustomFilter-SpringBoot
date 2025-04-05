package com.pinggy.assignment.filters;

import com.pinggy.assignment.Utility.AuthContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("Authentication filter initiated");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getMethod().equalsIgnoreCase("GET")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String authHeader = request.getHeader("PinggyAuthHeader");

        if(authHeader == null || authHeader.trim().isEmpty()){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or empty PinggyAuthHeader");
            return;
        }

        AuthContext.setAuthHeader(authHeader);


            filterChain.doFilter(servletRequest,servletResponse); // Proceed to the next step (controller)
        } finally {
            AuthContext.clear(); // Clear after request completion
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("Authentication filter destroyed");

    }
}
