package com.owls.owlworld.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final String jwtSecret = "12345";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (isAllow(request)) {
            return true;
        }

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Authorization header");
        }

        try {
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authorizationHeader).getBody();
            request.setAttribute("memberId", claims.get("memberId"));
            return true;
        } catch (JwtException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid JWT token");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private boolean isAllow(HttpServletRequest request) {
        String requestUri = ServletUriComponentsBuilder.fromRequestUri(request).build().getPath();
        String method = request.getMethod();
        if (requestUri.startsWith("/member")) {
            return true;
        }
        if (requestUri.startsWith("/auth")) {
            return true;
        }
        if (requestUri.startsWith("/university")) {
            return true;
        }

        if (requestUri.startsWith("/v2/api-docs")) {
            return true;
        }
        if (requestUri.startsWith("/swagger-resources")) {
            return true;
        }
        if (requestUri.startsWith("/swagger-ui")) {
            return true;
        }
        if (method.equals("GET") && requestUri.startsWith("/question")) {
            return true;
        }
        return false;
    }
}
