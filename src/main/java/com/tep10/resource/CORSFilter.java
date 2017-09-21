package com.tep10.resource;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by UG34QP on 19-9-2017.
 */
@Component
class CORSFilter implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
        response.setHeader("Access-Control-Max-Age", "3600");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
