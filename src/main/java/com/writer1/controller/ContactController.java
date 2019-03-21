package com.writer1.controller;

import com.writer1.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ContactController {

    @RequestMapping("/saveContact")
    public void saveContact(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username= (String) request.getSession().getAttribute("username");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String comments=request.getParameter("comments");
        printWriter(response,new ContactService().save(username,name,email,comments));
    }

    public void printWriter(HttpServletResponse response, Object obj) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(obj);
        out.close();
    }
}