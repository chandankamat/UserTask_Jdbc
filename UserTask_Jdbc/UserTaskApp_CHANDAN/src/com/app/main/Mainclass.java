package com.app.main;

import com.app.services.TaskServiceImpl;
import com.app.services.UserServiceimpl;
public class Mainclass
{
    public static void main(String[] args)
    {
        UserServiceimpl u1 = new UserServiceimpl();
                // u1.signup();
               // u1. updateProfile();
               //u1.deleteProfile();
               // u1.viewOneUser();
                //  u1.ViewAllUser();
        
        TaskServiceImpl ts= new TaskServiceImpl();
        
           // ts.addTask();
          //  ts.editTask();
         //   ts.deleteTask();
        //   ts.viewOneTask();
              ts.viewAllTasks();
          
            }
}