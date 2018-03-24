/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author strogiy.otec
 */
public abstract class GlobalExceptionHandler extends HttpServlet {

    private static final String ERROR_PATH = "/error";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            super.service(request, response);
        } catch (final Exception e) {
            request.setAttribute(ERROR_PATH, e);
            request.getRequestDispatcher(ERROR_PATH).forward(request, response);
        }
    }

}
