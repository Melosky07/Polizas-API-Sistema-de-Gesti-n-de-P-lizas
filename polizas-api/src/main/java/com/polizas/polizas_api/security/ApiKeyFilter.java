package com.polizas.polizas_api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY = "123456";
    private static final String HEADER_NAME = "x-api-key";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.startsWith("/h2") ||
            path.startsWith("/h2-console") ||
            path.startsWith("/error")) {

            filterChain.doFilter(request, response);
            return;
        }        

        String apiKey = request.getHeader(HEADER_NAME);

        if (apiKey == null || !API_KEY.equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("API KEY INVALIDA");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
