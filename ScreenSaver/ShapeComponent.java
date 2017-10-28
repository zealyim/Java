/**
   COPYRIGHT (C) 2013 Zeal Yim. All Rights Reserved.
   CPSC1181 ObjectOrientated
   Lab #5
   @version 4.2
   @author Zeal Yim
   @date 10/15/2013
*/
import java.lang.Math;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class ShapeComponent extends JComponent
{
   
   private int height, width;
   private int maxShapes;
   private final int TIMEDELAY = 10;

   private ArrayList <Shape3Animated> listOfShapes;
   private Timer timer;

   //default constructor not accessible
   private ShapeComponent ()
   {
      //do nothing
   }
   public ShapeComponent(int width, int height, int num)
   {
      this.height = height;
      this.width = width;
      listOfShapes = new ArrayList<Shape3Animated>();
      maxShapes = num;
      createShapes();
      
      class TimeListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            for(int i =0; i<listOfShapes.size();i++)
            {
               listOfShapes.get(i).move();
               repaint();
            }               
         }
      }      
      timer = new Timer(TIMEDELAY, new TimeListener());
      timer.start();
      

   }
   private void createShapes()
   {
      for(int i = 0; i < maxShapes; i++)
      {
         Shape3Animated s3Animate = new Shape3Animated(width, height);
         listOfShapes.add(s3Animate);         
      }
   }
   public void paintComponent (Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      for(int i = 0; i < listOfShapes.size(); i++)
      {
         listOfShapes.get(i).draw(g2);
      }
      //System.out.println("paint");
   }

   
   
   
}