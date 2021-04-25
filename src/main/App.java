package main;

import gamecomponents.Power;
import interfaces.MainInterface;

public class App {
    
    public static Power poder=null;

    public static void main(String[] args) {
        
        MainInterface mainInterface = new MainInterface(); 
        mainInterface.setVisible(true);
    }

}
