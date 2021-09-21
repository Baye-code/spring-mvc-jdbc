package com.bogal.daoImpl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bogal.beans.Student;
import com.bogal.dao.StudentDao;
import com.bogal.daofactory.DaoFactory;


public class StudentDaoImpl implements StudentDao{
	
    private DaoFactory daoFactory;

    public StudentDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    
    public void add(Student student) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = 
            		connexion.prepareStatement
            		("INSERT INTO student(lastName, firstName, email, "
            				+ "gender, yearScholar) VALUES(?, ?, ?, ?, ?);");
            
            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getYearScholar());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    
    public List<Student> listAll() {
        List<Student> students = new ArrayList<Student>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT lastName, firstName, email, gender, yearScholar FROM student;");

            while (resultat.next()) {
                String lastName = resultat.getString("lastName");
                String firstName = resultat.getString("firstName");
                String email = resultat.getString("email");
                String gender = resultat.getString("gender");
                String yearScholar = resultat.getString("yearScholar");

                Student student = new Student();
                student.setLastName(lastName);
                student.setFirstName(firstName);
                student.setEmail(email);
                student.setGender(gender);
                student.setYearScholar(yearScholar);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

	public void update(Student student) {
		
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = 
	            connexion.prepareStatement
	            		("UPDATE student SET lastName = ?, firsName = ?, email = ?,"
	            				+ "gender = ?, yearSholar = ? WHERE id = ?");
	            
	            preparedStatement.setString(1, student.getLastName());
	            preparedStatement.setString(2, student.getFirstName());
	            preparedStatement.setString(3, student.getEmail());
	            preparedStatement.setString(4, student.getGender());
	            preparedStatement.setString(5, student.getYearScholar());
	            preparedStatement.setObject(6, student.getId());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}

	public void delete(Student student) {

		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = 
	            connexion.prepareStatement
	            		("DELETE FROM student WHERE email=?;");
	            
	            preparedStatement.setString(1, student.getEmail());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}







