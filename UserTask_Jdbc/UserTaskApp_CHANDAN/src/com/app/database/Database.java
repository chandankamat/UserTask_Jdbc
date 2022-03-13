package com.app.database;

import java.util.List;
import com.app.entities.Task;
import com.app.entities.User;
public interface Database {
	
	public void insert(Object obj);
	public void update(Object obj);
	public void delete(Object obj);
	
	public Object selectOne(Object obj);
	List<Object> selectMany(Object obj);
    List<Object> selectAll(Object obj);     
 
}