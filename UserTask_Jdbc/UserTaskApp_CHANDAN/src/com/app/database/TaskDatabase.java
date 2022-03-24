package com.app.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Task;

public class TaskDatabase extends DatabaseUtils implements Database {
	private	String insertQuery      ="insert into usersdb.task values(0,?,?,?,?,?,?);";
        private String updateQuery      ="update usersdb.task set Status = ? where Status = ? ;";
	private String deleteQuery      ="delete from usersdb.task where Taskname = ?;";
	private String selectOneQuery   ="select * from usersdb.task where tid= ?;";
	private String selectManyQuery  ="select * from usersdb.task where UID= ?;";;



	@Override
	public void insert(Object obj)
	{

		connect();

		 try {
			pstmt= con.prepareStatement(insertQuery);
			
            Task t1 = (Task)obj;	
            
			pstmt.setString(1, t1.getName());
			pstmt.setString(2, t1.getDescription());
			pstmt.setString(3, t1.getStatus());
			pstmt.setString(4, t1.getStartDate());
			pstmt.setString(5, t1.getEndDate());
			pstmt.setInt(6, t1.getUid());
		
			pstmt.executeUpdate();
			
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		disConnect();
		
	}

	@Override
	public void update(Object obj) {
		
		connect();
		try 
		{
			pstmt= con.prepareStatement(updateQuery);
			
			Task t1= (Task)obj;
			
			pstmt.setString(1, t1.getOldStatus());
			pstmt.setString(2, t1.getNewStatus());
			
			pstmt.executeUpdate();

			

		}
		catch (SQLException e)
		
		{
			e.printStackTrace();
		}
		
		disConnect();
	}

	@Override
	public void delete(Object obj) 
	{
		connect();
		
		try
		{
			pstmt= con.prepareStatement(deleteQuery);
			 Task t1=(Task)obj;
			 
				pstmt.setString(1, t1.getName());
				
				pstmt.executeUpdate();

			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		disConnect();
	}

	
	@Override
	public Object selectOne(Object obj) 
	{
		
		connect();
		
		Task t1 = new Task();
		
		try {
			pstmt = con.prepareStatement(selectOneQuery );
			
			Integer id = (Integer)obj;
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			int tid = rs.getInt("TID");
			String taskName    = rs.getNString("Taskname");
			String description = rs.getNString("Description");
			String status      = rs.getNString("Status");
			String startDate   = rs.getNString("Start_Date");
			String endDate     = rs.getNString("End_Date");
			int    uid         = rs.getInt("UID");
			
			t1.setTid(tid);
			t1.setName(taskName);
			t1.setDescription(description);
			t1.setStatus(status);
			t1.setStartDate(startDate);
			t1.setEndDate(endDate);
			t1.setUid(uid);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		disConnect();
		return t1;
	}
	

	@Override
	public List<Object> selectMany(Object obj) {
		List<Object> taskList = new ArrayList<Object>();
		try {
			
			connect();
			
			pstmt = con.prepareStatement(selectManyQuery);
			
			Integer id = (Integer) obj;
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next() == true) {
				
				Task t1 = new Task();
				
				int tid = rs.getInt("TID");
				String taskName    = rs.getNString("Taskname");
				String description = rs.getNString("Description");
				String status      = rs.getNString("Status");
				String startDate   = rs.getNString("Start_Date");
				String endDate     = rs.getNString("End_Date");
				int    uid         = rs.getInt("UID");
				
				t1.setTid(tid);
				t1.setName(taskName);
				t1.setDescription(description);
				t1.setStatus(status);
				t1.setStartDate(startDate);
				t1.setEndDate(endDate);
				t1.setUid(uid);
				
				
				taskList.add(t1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disConnect();
		return taskList;
	}
	@Override
	public List<Object> selectAll(Object obj)
	{
		List<Object> taskList = new ArrayList<Object>();
		try {
			
			connect();
			
			pstmt = con.prepareStatement(selectManyQuery);
			
			Integer id = (Integer) obj;
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next() == true) {
				
				Task t1 = new Task();
				
				int tid = rs.getInt("TID");
				String taskName    = rs.getNString("Taskname");
				String description = rs.getNString("Description");
				String status      = rs.getNString("Status");
				String startDate   = rs.getNString("Start_Date");
				String endDate     = rs.getNString("End_Date");
				int    uid         = rs.getInt("UID");
				
				t1.setTid(tid);
				t1.setName(taskName);
				t1.setDescription(description);
				t1.setStatus(status);
				t1.setStartDate(startDate);
				t1.setEndDate(endDate);
				t1.setUid(uid);
				
				
				taskList.add(t1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disConnect();
		return taskList;
	}

	
	}
	
		

