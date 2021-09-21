package com.bogal.dao;


import java.util.List;
import com.bogal.beans.*;

public interface StudentDao {
	
	void add( Student student);
	void update(Student student);
	void delete(Student student);
    List<Student> listAll();

}


