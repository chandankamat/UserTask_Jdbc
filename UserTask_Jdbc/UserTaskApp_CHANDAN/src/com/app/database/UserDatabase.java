package com.app.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.app.entities.User;

public class UserDatabase extends DatabaseUtils implements Database {

	private String insertQuery    = "insert into UsersDB.User values(0,?,?,?,?);";
	private  String updateQuery   = "update UsersDB.User set email = ? where email = ? ;";
	private String deleteQuery    = "delete from usersdb.user where email = ?;";
    private String selectOneQuery = "select * from usersdb.user where uid= ?;";
   // private String selectManyQuery = "select * from usersdb.user where uid= ?;";

	@Override
	public void insert(Object obj) 
	{
		//connect db
		connect();
		 
		try {
			pstmt = con.prepareStatement(insertQuery);
			User u1= (User)obj;
			
			pstmt.setString(1, u1.getName());
			pstmt.setString(2, u1.getEmail());
			pstmt.setString(3, u1.getPassword());
			pstmt.setString(4, u1.getMob());

			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	     
		//diSconnect db
		disConnect();
	}

	@Override
	public void update(Object obj) {
		
		connect();
		
		 try
			{
		    	
		    	pstmt =con.prepareStatement(updateQuery); 
		    	User u1=(User)obj;
		    	
		    	pstmt.setString(1,u1.getNewEmail());
		    	pstmt.setString(2,u1.getOldEmail());
		    	
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
		
	//connect to db
			connect();
			
			try
			{
				
				pstmt=con.prepareStatement(deleteQuery);
				User u1=(User)obj;
				
				pstmt.setString(1,u1.getEmail());//creates a statement object for sending SQL statements to the database.
				pstmt.executeUpdate();//delete the row
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//disconnect to db
		  disConnect();
			
		}
	

	@Override
	public Object selectOne(Object obj) {
		

		connect();
		
		User u1 = new User();
		
		try {
			pstmt = con.prepareStatement(selectOneQuery );
			
			Integer id = (Integer)obj;
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			int uid = rs.getInt("UID");
			String  Name        = rs.getNString("name");
			String  email       = rs.getNString("Email");
			String  password    = rs.getNString("PASSWORD");
			String  mob         = rs.getNString("MOB");
			
			u1.setUID(uid);
			u1.setName(Name);
			u1.setEmail(email);
			u1.setPassword(password);
			u1.setMob(mob);
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		disConnect();
		return u1;
	}

	@Override
	public  List<Object> selectMany(Object obj) {
		 return null;
	}
    
	@Override
	public  List<Object> selectAll(Object obj) {
		 return null;

}
}