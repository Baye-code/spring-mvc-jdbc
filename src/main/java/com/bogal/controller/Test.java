package com.bogal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.octest.bdd.Noms;
import com.bogal.beans.Student;
import com.bogal.dao.*;
import com.bogal.daofactory.DaoFactory;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.studentDao = daoFactory.getStudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("students", studentDao.listAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Student student = new Student();
        student.setLastName(request.getParameter("lastName"));
        student.setFirstName(request.getParameter("firstName"));
        student.setEmail(request.getParameter("email"));
        student.setGender(request.getParameter("gender"));
        student.setYearScholar(request.getParameter("yearScholar"));
        
        studentDao.add(student);
        
        request.setAttribute("students", studentDao.listAll());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
    
    

}