/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab4.entities.Item;
import static lab4.entities.Item.ADIDAS;
import static lab4.entities.Item.MUIT;
import static lab4.entities.Item.NIKE;

/**
 *
 * @author strogiy.otec
 */
@WebServlet(urlPatterns = {"/bascet"})
public class BascetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        List<Item> list = (List<Item>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new Item(req.getParameter("company"), Integer.parseInt(req.getParameter("price"))));
        list.forEach(System.out::println);
        session.setAttribute("list", list);
        resp.sendRedirect("bascet.html");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        List<Item> list = (List<Item>) session.getAttribute("list");
        if (list == null) {
            resp.sendRedirect("bascet.html");
            return;
        }
        final int totalPrice = list.stream().mapToInt(p -> p.getPrice()).sum();
        req.setAttribute("sum", totalPrice);
        req.setAttribute("adidas", Collections.frequency(list, ADIDAS));
        req.setAttribute("nike", Collections.frequency(list, NIKE));
        req.setAttribute("muit", Collections.frequency(list, MUIT));
        req.getRequestDispatcher("all_baskets.jsp").forward(req, resp);
    }

}
