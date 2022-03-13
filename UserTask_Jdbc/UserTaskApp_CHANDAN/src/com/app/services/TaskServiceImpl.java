package com.app.services;

import java.util.List;
import java.util.Scanner;

import com.app.database.TaskDatabase;
import com.app.entities.Task;

public class TaskServiceImpl implements TaskService {

	Scanner scn = new Scanner(System.in);
	TaskDatabase tdb = new TaskDatabase();
	
	@Override
	public void addTask() 
	{
		
	System.out.println("Task add Started");
	  Task t1 = new Task();
		
	  System.out.println("Enter the Task Name..");
      t1.setName(scn.next());
      
      System.out.println("Enter the Task Description");
      t1.setDescription(scn.next());
      
      System.out.println("Enter the Task Status");
      t1.setStatus(scn.next());
      
      System.out.println("Enter the Task Start Date ");
      t1.setStartDate(scn.next());
      
      System.out.println("Enter the Task End Date");
      t1.setEndDate(scn.next());
      
      System.out.println("Enter the Task uid");
      t1.setUid(scn.nextInt());
      
        tdb.insert(t1);
        
        System.out.println("addTask added Sucessfully");  
	}

	@Override
	public void editTask() 
	{
		System.out.println("Task edit Started");
		  Task t1 = new Task();
			
		  System.out.println("Enter the newstatus..");
	      t1.setOldStatus(scn.next());
	      
	      System.out.println("Enter the oldStatus..");
	      t1.setNewStatus(scn.next());
	      
	       tdb.update(t1);
	       
	       System.out.println("edit Task added Suceessfully..");
		
	}

	@Override
	public void deleteTask()
	{
		System.out.println("Task deleted Started");
		  Task t1 = new Task();
			
		  System.out.println("Enter the Taskname..");
	      t1.setName(scn.next());
		
		  tdb.delete(t1);
		  
		  System.out.println("deleted Task Sucessfully");
	      
	}

	@Override
	public void viewOneTask() {
		
		 System.out.println("Please enter your Task id..");
	      int tid=scn.nextInt();
		
         Task t1=(Task)tdb.selectOne(tid);
         
         System.out.println("TID :"+t1.getTid());
         System.out.println("NAME :"+t1.getName());
         System.out.println("DESC :"+t1.getDescription());
         System.out.println("STATUS:"+t1.getStatus());



	}

	@Override
	public void viewAllTasks()
	{
		System.out.println("Please enter your USER id");
		int tid = scn.nextInt();
		List<Object> taskList = tdb.selectMany(tid);
		for (Object obj : taskList) 
		{
			Task t1 = (Task) obj;
			System.out.println("TID  : " + t1.getTid());
			System.out.println("NAME  : " + t1.getName());
			System.out.println("DESC  : " + t1.getDescription());
			System.out.println("Status : " + t1.getStatus());
		}
	}
}