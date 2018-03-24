/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.filters;

import java.io.IOException;
import java.rmi.AccessException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab4.dao.UserDao;
import lab4.entities.User;
import static lab4.filters.LoginFilter.ERROR_PATH;

/**
 *
 * @author strogiy.otec
 */
@WebFilter("/show.jsp")
public class GetUserJspFilter implements Filter {

    private FilterConfig fc;

    @Inject
    private UserDao dao;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        this.fc = fc;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            request.setAttribute(ERROR_PATH, new AccessException("There is no session in your request"));
            request.getRequestDispatcher(ERROR_PATH).forward(request, response);
            return;
        } else if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            System.out.println("TUT");
            try {
                dao.findByLoginAndPassword(user.getLogin(), user.getPassword());
            } catch (Exception exc) {
                ((HttpServletResponse) response).sendRedirect("index.html");
                return;
            }

        }
        fc.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
