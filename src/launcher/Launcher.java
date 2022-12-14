package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student estudiante = new Student(134138,"Moreno","Martina","martumoreno6@gmail.com","https://github.com/MartinaMoreno/tdp-proyecto-1/", "/images/6356630.png");
            	
            	SimplePresentationScreen s = new SimplePresentationScreen(estudiante);
            	s.setVisible(true);
            }
        });
    }
}