/**
   COPYRIGHT (C) 2013 Zeal Yim. All Rights Reserved.
   CPSC1181 ObjectOrientated
   Lab #5
   @version 4.2
   @author Zeal Yim
   @date 10/15/2013
*/
import java.awt.Graphics2D;
import java.awt.Color;

public class Shape3Animated extends Shape3
{
   private final int BASIC_DIAMETER = 4;    //in this case each combine object is 8r
   private final int BASIC_RADIUS = BASIC_DIAMETER/2;
   private final int MINRADIUS = 10;
   private final int MAXRADIUS = 50;
   private final int DIRECTIONS = 2;
   private final int MINVELOCTIY = 1;
   private final int MAXVELOCITY = 10;
   int frameWidth, frameHeight;
   int radius;
   double xCoor;
   double yCoor;       
   // @param xDirection indicates a random xDirection (left, right, top ,bottom)
   private String xDirection;
   private String yDirection;
   private int velocity;    
   private Shape3 shape3;
   private Color oldShapeColor;
   
   // moves the x or y coordinates of the shape based on xDirection and velocity
   public Shape3Animated(int width, int height)
   {
      frameWidth = width;
      frameHeight = height;
      radius = randomRadiusGenerator();
      xCoor = randomCoorGenerator(frameWidth);
      yCoor = randomCoorGenerator(frameHeight);
      randomDirctionGenerator();
      randomeVeloctiyGenerator();      
      shape3 = new Shape3(xCoor, yCoor, radius);
      oldShapeColor = shape3.getColor();
   }
   private int getActualXTop()
   {
      return (int)(shape3.getX() - (getLongSide()*radius/2));
   }
   private int getActualYTop()
   {
      return (int)(shape3.getY() - (getLongSide()*radius/2));
   }
   private int getActualXEnd()
   {
      return (int)(shape3.getX() + (getLongSide()*radius/2));
   }
   private int getActualYEnd()
   {
      return (int)(shape3.getY() + (getLongSide()*radius/2));
   }
   private void changeDirection()
   {
      if(getActualXTop() <= 0|| getActualXEnd() >= frameWidth)
      {
         switch(xDirection)
         {
         case "right": xDirection = "left";break;
         case "left": xDirection = "right";break;
         }
      }
      if(getActualYTop()<= 0 ||getActualYEnd() >= frameHeight)
      {
         switch(yDirection)
         {
            case "up": yDirection = "down";break;
            case "down": yDirection = "up";break;
         }
      }
   }
   public void move()
   {  
      changeDirection();
      
      switch(xDirection)
      {
         case "right": xCoor += velocity;break;
         case "left": xCoor -= velocity;break;
      }
      switch(yDirection)
      {
         case "up": yCoor += velocity;break;
         case "down": yCoor -= velocity;break;
      }
      shape3 = new Shape3(xCoor, yCoor, radius);
      shape3.setColor(oldShapeColor);
   }
   public void draw(Graphics2D g2)
   {
      shape3.draw(g2);
   }
   private void randomDirctionGenerator()
   {
      int n = (int)(Math.random()*DIRECTIONS);
      switch (n)
      {
         case 0: xDirection = "right";break;
         case 1: xDirection = "left";break;
      }
      n = (int)(Math.random()*DIRECTIONS);
      switch (n)
      {
         case 0: yDirection = "up";break;
         case 1: yDirection = "down";break;
      }

   }
   private double randomCoorGenerator(int x)
   {
      //System.out.println(x+" "+((radius*BASIC_DIAMETER)) + " " + (radius*BASIC_RADIUS));
      double coordinate = (int)((Math.random()*(x-(radius*BASIC_DIAMETER)))+(radius*BASIC_RADIUS));      // coor = randomNumber * (x - 4r) + 2r
      return coordinate;
   }
   private int randomRadiusGenerator()
   {
      int radius = (int)(Math.random()*(MAXRADIUS-MINRADIUS)+MINRADIUS);
      //System.out.println("radius: "+ radius);
      return radius;
   }   
   private void randomeVeloctiyGenerator()
   {
      velocity = (int)(Math.random()*(MAXVELOCITY-MINVELOCTIY))+MINVELOCTIY;
   }
}