/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanboard;

/**
 *
 * @author Dillon Rinkwest ST10439147 PROG5121 Gr01
 */
class DeveloperClass
    {
    //-------------VARIABLES--------------------------//
        private String devName;
       // private String devSurname;
        private int duration;

        //-----------------------------------------------------------------------------------------------------------------------------------//
        //CONSTRUCTOR
        public DeveloperClass(String devName, int duration) {
            this.devName = devName;
           // this.devSurname = devSurname;
            this.duration = duration;
        }

        //-----------------------------------------------------------------------------------------------------------------------------------//
        public String getDevName() {
            return devName;
        }

        
        //-----------------------------------------------------------------------------------------------------------------------------------//
        public int getDuration() {
            return duration;
        }
}
//---------------------------------DDDDooooooooooooooooooooo END OF FILE DDDDooooooooooooooooooooo-------------------------------------------//
