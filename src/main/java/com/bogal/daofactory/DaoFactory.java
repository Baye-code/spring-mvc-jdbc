package com.bogal.daofactory;

import com.bogal.dao.StudentDao;
import com.bogal.daoImpl.StudentDaoImpl;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//
//        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/studentDB?"
                	+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                		+ "useLegacyDatetimeCode=false&serverTimezone=UTC", 
                			"root", "passer@1");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public StudentDao getStudentDao() {
        return new StudentDaoImpl(this);
    }
}
