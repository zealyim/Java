/**
   COPYRIGHT (C) 2013 Zeal Yim. All Rights Reserved.
   CPSC1181 ObjectOrientated
   Lab #5
   @version 4.2
   @author Zeal Yim
   @date 10/15/2013
*/
import javax.swing.*;

public class ShapeViewer
{
   public static void main(String[]args)
   {
      JFrame frame = new JFrame();
      
      int frameWidth = 1000;
      int frameHeight = 700;
      
      frame.setSize(frameWidth, frameHeight);
      frame.setTitle("Flyin' Shapes");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      String result;

      do {
         result = JOptionPane.showInputDialog("How many shapes do you want? (Input a positive interger)");
         if(result == null) return;
      }while( result.isEmpty() || result.matches("//d*")
              || Integer.parseInt(result) < 0); //use "regular expression" to check input

      
      ShapeComponent component = new ShapeComponent(frameWidth,frameHeight, Integer.parseInt(result));
      frame.add(component);
      
      frame.setVisible(true);
      
   }
}