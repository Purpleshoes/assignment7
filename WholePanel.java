// Assignment #: 7
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture days/time
//  Arizona State University CSE205
//  Description: It needs to be filled.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private Color currentColor = Color.black;
   private CanvasPanel canvas;
   private JPanel topPanel;
   private JButton undo;
   private ArrayList shapeList;
   int flag = 1; //Debug
   private String currentShape = "circle";
   private int currentSize = 10;
   
   private ArrayList pointList;
  
   Shape nShape;
   
   
   JComboBox<String> comboShapes = new JComboBox<String>();
   JComboBox<Integer> comboSize = new JComboBox<Integer>();
   JComboBox<String> comboColors = new JComboBox<String>();

   public WholePanel() {
	  currentColor = Color.black;
      shapeList = new ArrayList();
      pointList = new ArrayList();

      topPanel = new JPanel();
      
      canvas = new CanvasPanel();
      
 	  JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);
      
      undo = new JButton ("Undo");
      
      JComboBox<String> comboShapes = new JComboBox<String>();
      comboShapes.addItem("circle");
      comboShapes.addItem("square");
      
      JComboBox<Integer> comboSize = new JComboBox<Integer>();
      comboSize.addItem(10);
      comboSize.addItem(20);
      comboSize.addItem(30);
      comboSize.addItem(40);
      comboSize.addItem(50);
      
      JComboBox<String> comboColors = new JComboBox<String>();
      comboColors.addItem("black");
      comboColors.addItem("red");
      comboColors.addItem("blue");
      comboColors.addItem("green");
      comboColors.addItem("orange");
      
      topPanel.add(comboShapes, BorderLayout.WEST);
      topPanel.add(comboSize, BorderLayout.CENTER);
      topPanel.add(comboColors, BorderLayout.EAST);
      topPanel.add(undo, BorderLayout.EAST);
    }

  //CanvasPanel is the panel where shapes will be drawn
  private class CanvasPanel extends JPanel {
	  
      //this method draws all shapes 
      public void paintComponent(Graphics page)
       {
	        super.paintComponent(page);
	        setBackground(Color.WHITE);
	        	
	        //page.setColor(nShape.color);
	        	//page.drawOval(nShape.x, nShape.y, nShape.width, nShape.height);
	        	//page.fillOval(nShape.x, nShape.y, nShape.width, nShape.height);
	        
	        for (int i = 0; i < shapeList.size(); i++) {
	        	//Point drawPoint = (Point) pointList.get(i);
	        	((Shape) shapeList.get(i)).draw(page);
	        }
       }     
    } //end of CanvasPanel class

   //ButtonListener defined actions to take in case
   //"Undo" is chosen.
   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
          undo = new JButton ("Undo");
          undo.addActionListener (new ButtonListener());
      }
   } // end of ButtonListener

   // listener class to set the color chosen by a user using
   // color combo box, set the size chosen using size combo box
   // or set the shape (circle or square) using shape combo box
   private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
         {
        	if (event.getSource() == comboShapes) {
        		currentShape = (String) comboShapes.getSelectedItem();
        	}
        	
        	if (event.getSource() == comboSize) {
        		currentSize = (int) comboSize.getSelectedItem();
        	}

        	if (event.getSource() == comboColors) {
        		currentColor = Color.getColor((String) comboColors.getSelectedItem());
        	}
         }
    } // end of ComboListener


   // listener class that listens to the mouse
   public class PointListener implements MouseListener
    {
	 //in case that a user presses using a mouse,
	 //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
    	 Point pt = event.getPoint();
    	 //pointList.add(event.getPoint());
    	 if (currentShape.equals("circle")) {
    		 nShape = new Circle((int)pt.getX(), (int)pt.getY(), currentSize, currentSize, currentColor);
    		 shapeList.add(nShape);
    	 } else {
    		 nShape = new Square((int)pt.getX(), (int)pt.getY(), currentSize, currentSize, currentColor);
    		 shapeList.add(nShape);
    	 }
    	 repaint();
          
      }
     public void mouseReleased (MouseEvent event) {}
     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}

    } // end of PointListener

} // end of Whole Panel Class