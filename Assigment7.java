// Assignment #: 7
//         Name: Paxton Ostler
//    StudentID: 1206707264
//      Lecture: M/W 6 - 715PM
//  Arizona State University CSE205
//  Description: The Assignment 7 creates a WholePanel that is
//  an extension of JPanel, add it to its content, and set
//  a size for the applet.


import java.awt.*;
import javax.swing.*;

public class Assigment7 extends JApplet
{

 public void init()
  {
	 WholePanel wholePanel = new WholePanel();
	 getContentPane().add(wholePanel);
	 
	 setSize (400, 400);
  }

}