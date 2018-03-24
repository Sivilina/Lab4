/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.servlets;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author strogiy.otec
 */
@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        final Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            final String element = paramNames.nextElement();
            if(!element.equals("data"))
            session.setAttribute(element, req.getParameter(element));
        }
        final String appropriateRedirect = req.getParameter("data");
        switch (appropriateRedirect) {
            case "1": {
                resp.sendRedirect("second.html");
                return;
            }
            case "2": {
                resp.sendRedirect("third.html");
                return;
            }
            case "3": {
                resp.sendRedirect("result.jsp");
                return;
            }
            default: {
                throw new UnsupportedOperationException("Data: " + appropriateRedirect + " is not supported");
            }

        }
    }

}
