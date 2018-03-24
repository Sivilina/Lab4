/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author strogiy.otec
 */
@WebFilter("/users")
public class LoginFilter implements Filter {

    private FilterConfig fc;
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String ERROR_PATH = "/error";
    public static final String POST = "POST";

    @Override
    public void init(FilterConfig fc) throws ServletException {
        this.fc = fc;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        final HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equalsIgnoreCase(POST)) {
            if (!isValiвPostRequest(request)) {
                request.setAttribute(ERROR_PATH, new IllegalArgumentException("Wrong request params"));
                request.getRequestDispatcher(ERROR_PATH).forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    private boolean isValiвPostRequest(ServletRequest request) {
        return request.getParameter("login") != null && request.getParameter("password") != null;
    }

}
