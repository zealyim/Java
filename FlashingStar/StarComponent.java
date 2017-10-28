import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.lang.Math;
import java.awt.Color;
import java.util.ArrayList;


//to create stars and print them
public class StarComponent extends JComponent
{
   
   private final int COLOURRANGE = 256;
   private double width;
   private double height;
   private double centerX;
   private double centerY;
   private final int NUMOFCENTERSTAR = 15;
   private final int NUMOFCIRLCESTAR = 10;
   private final int RADOFCIRCLE;
   private final int RADOFSMALLSTARS;
   private final int TOTALDEGREE = 360;
   private final int DEGREEFOREACHSTAR = TOTALDEGREE/NUMOFCIRLCESTAR;
   private final int LARGESTSTAR = 225;
   private final int STARDIFFERENCE = 15;

   private ArrayList<Star> listOfStar = new ArrayList<Star>();;
   
   //defalut constructor for StarComponent
   public StarComponent ()
   {
      this(700,800);
   }
   
   //constructor for StarComponent
   public StarComponent (int width, int height)
   {
      this.width = width;      
      this.height = height;
      this.centerX = width/2;
      this.centerY = height/2;
      RADOFCIRCLE = width / 3;
      RADOFSMALLSTARS = width / 50;
      createCenterStars();
      createCircleStars();
   }
   
   //to generate randome color and return the color
   private Color randomColorGenerator () 
   {
      int red = (int)(Math.random()*COLOURRANGE);
      int green = (int)(Math.random()*COLOURRANGE);
      int blue = (int)(Math.random()*COLOURRANGE);
      Color newColor = new Color (red,green,blue);
      return newColor;
   }
   //create stars for the center partand add into listOfStars
   private void createCenterStars()
   {      
      for(int index=0, radius = LARGESTSTAR; index < NUMOFCENTERSTAR;index++, radius-=STARDIFFERENCE)
      {
         Star star = new Star(radius, centerX, centerY);
         listOfStar.add(star);
      }
   }
   //creat start that ciucular the center stars and add into listOfStars
   private void createCircleStars()
   {
      for(int index = 1, radius = LARGESTSTAR; index <= NUMOFCIRLCESTAR;index++)
      {
         int newX = (int)(centerX + (RADOFCIRCLE*(Math.cos(Math.toRadians(DEGREEFOREACHSTAR*index)))));
         int newY = (int)(centerY + (RADOFCIRCLE*(Math.sin(Math.toRadians(DEGREEFOREACHSTAR*index)))));
         Star star = new Star(RADOFSMALLSTARS, newX , newY );
         listOfStar.add(star);
      }
      
   }
   //print all stars in listOfStars
   public void paintComponent(Graphics g)
   {
      
      Graphics2D g2 = (Graphics2D) g;
      

      
      for(int index =0; index < listOfStar.size(); index++)
      {
         g2.setColor(randomColorGenerator());
         listOfStar.get(index).drawShape(g2);      
         g2.setColor(randomColorGenerator());
         listOfStar.get(index).drawLine(g2);
      }   
      
   }
   
}