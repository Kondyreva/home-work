package com.sbrf.reboot.lab15.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import  java.util.concurrent.atomic.AtomicInteger;
import java.io.IOException;

@WebServlet("/name")
public class Servlet extends HttpServlet {
    private AtomicInteger visitCounter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        visitCounter = (AtomicInteger) session.getAttribute("visitCounter");
        visitCounter.incrementAndGet();

        session.setAttribute("visitCounter", visitCounter);

        String username = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        if(username == null){
            printWriter.write("Hello, anonym" + "<br>");
        }else {
            printWriter.write("Hello, " + username + "<br>");
        }
        printWriter.write("Counter = " + visitCounter);
        printWriter.close();
    }

}

