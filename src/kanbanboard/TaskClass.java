/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG5121 Gr01
 */

    class TaskClass 
    {
        private String taskName;
        private String status;
        private String description;
        private int taskNo;
        private String ID;
        private DeveloperClass developer;

        //----------------------------------------------------------------------------------------//
        //DEFAULT CONSTRUCTOR
        public TaskClass(String taskName, String status, String description, int taskNo) 
        {
            this.taskName = taskName;
            this.status = status;
            this.description = description;
            this.taskNo = taskNo;
        }

         //----------------------------------------------------------------------------------------//
        public String getTaskName() {
            return taskName;
        }
        
        //----------------------------------------------------------------------------------------//
        public String getStatus() 
        {
            return status;
        }
        
         //----------------------------------------------------------------------------------------//    
        public String getDescription() 
        {
            return description;
        }

         //----------------------------------------------------------------------------------------//
        public int getTaskNo() 
        {
            return taskNo;
        }

         //----------------------------------------------------------------------------------------//
        public String getID() 
        {
            return ID;
        }

         //----------------------------------------------------------------------------------------//
        public DeveloperClass getDeveloper() 
        {
            return developer;
        }

         //----------------------------------------------------------------------------------------//
        public void setID(String ID) 
        {
            this.ID = ID;
        }
        
         //----------------------------------------------------------------------------------------//
        public void setDeveloper(DeveloperClass developer) 
        {
            this.developer = developer;
        }
    }
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//
