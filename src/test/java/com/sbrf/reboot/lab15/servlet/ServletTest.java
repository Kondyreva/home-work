package com.sbrf.reboot.lab15.servlet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServletTest {

    private final Servlet servlet = new Servlet();

    @Test
    void doGet() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Object counter = 0;

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("visitCounter")).thenReturn(counter);
        when(request.getParameter("name")).thenReturn("Tatyana");
        when( response.getWriter()).thenReturn(printWriter);

        servlet.doGet(request, response);

        verify(request, atLeast(1)).getParameter("name");
        assertTrue(stringWriter.toString().contains("Hello, Tatyana"));
        assertTrue(stringWriter.toString().contains("Counter = 1"));
    }
}