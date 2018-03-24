/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.servlets;

import java.io.IOException;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab4.entities.ErrorMessage;

/**
 *
 * @author strogiy.otec
 */
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    private static final String ERROR_PATH = "/error";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HERE");
        final Exception exception = (Exception) req.getAttribute(ERROR_PATH);
        resp.setStatus(HTTP_BAD_REQUEST);
        final ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), HTTP_BAD_REQUEST);
        req.setAttribute("errorMessage", errorMessage);
        req.getRequestDispatcher("error.jsp").forward(req, resp);
    }

}
