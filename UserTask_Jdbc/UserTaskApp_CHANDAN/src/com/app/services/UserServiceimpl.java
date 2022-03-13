  package com.app.services;

import java.util.Scanner;

import com.app.database.UserDatabase;
import com.app.entities.Task;
import com.app.entities.User;

public class UserServiceimpl implements UserService {

	  Scanner scn= new Scanner(System.in);
	  UserDatabase usDB = new  UserDatabase();
	  
	@Override
	public void signup() 
	{
		System.out.println("User signup started");
		
		
		User u1= new User();		
		System.out.println("Enter your Name");
		u1.setName(scn.next());
		
		System.out.println("Enter your Email");
		u1.setEmail(scn.next());

		System.out.println("Enter your Password");
		u1.setPassword(scn.next());
		
	  System.out.println("Enter your Mob");
      u1.setMob(scn.next());
		
		usDB.insert(u1);



		
		System.out.println("user signup is successfull");
	}
	@Override
	public void updateProfile() 
	{
		System.out.println("User Update Started");
		User u1= new User();
		
		System.out.println("Enter your NewEmail");
        u1.setOldEmail(scn.next());
        
        System.out.println("Enter your OldEmail ");
        u1.setNewEmail(scn.next());
        
        usDB.update(u1);
        
        System.out.println("User Update is Successful");
	}
     
	@Override
	public void deleteProfile() 
	
	{
		System.out.println("User Delete Started");
		System.out.println("Enter your Email");
		User  u1= new User();
        u1.setEmail(scn.next());
        usDB.delete(u1);
		System.out.println("user profile was delete successfull");

	}

	@Override
	public void viewOneUser() {
		System.out.println("Please enter your User id..");
	      int uid=scn.nextInt();
		
       User u1=(User)usDB.selectOne(uid);
       
       System.out.println("UID      :  "+u1.getUID());
       System.out.println("NAME     :  "+u1.getName());
       System.out.println("EMAIL    :  "+u1.getEmail());
       System.out.println("PASSWORD :  "+u1.getPassword());
       System.out.println("MOB      :  "+u1.getMob());
		
	}

	@Override
	public void ViewAllUser() 
	{
		System.out.println("Please enter your User id..");
	      int uid=scn.nextInt();
		
     User u1=(User)usDB.selectMany(uid);
     
     System.out.println("UID      :  "+u1.getUID());
     System.out.println("NAME     :  "+u1.getName());
     System.out.println("EMAIL    :  "+u1.getEmail());
     System.out.println("PASSWORD :  "+u1.getPassword());
     System.out.println("MOB      :  "+u1.getMob());
		
	}

}
