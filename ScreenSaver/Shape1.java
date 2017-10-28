/**
   COPYRIGHT (C) 2013 Zeal Yim. All Rights Reserved.
   CPSC1181 ObjectOrientated
   Lab #5
   @version 4.2
   @author Zeal Yim
   @date 10/15/2013
*/
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.lang.Math;
import java.awt.Color;

public class Shape1
{
   private double xTop, yTop;
   private double x, y, r;
   private double width, height;
   private final int MAXCOLOR = 256;
   protected Color shapeColor;
   private final double LONGSIDERATIO = 4;
   private final double SHORTSIDERATIO = 2;
   
   /*default constructor
      @param xTop is the top left x coordinate of shape
      @param yTop is the top left y coordinate of shape
      */
   public Shape1()
   {

   }
   /*constructor for shape1
      @param xTop is the top left x coordinate of shape
      @param yTop is the top left y coordinate of shape
      */
   public Shape1(double x, double y, double r)
   {
      this.x = x;
      this.y = y;
      this.r = r;
      randomColor();
      
   }
   //create a new color
   public void randomColor()
   {
      int red = (int)(Math.random()*MAXCOLOR);
      int green = (int)(Math.random()*MAXCOLOR);
      int blue = (int)(Math.random()*MAXCOLOR);
      Color newColor = new Color(red,green,blue);
      this.shapeColor = newColor;
   }
   /*draw the shape
      @param g2 is the graphics context*/
   public void draw(Graphics2D g2)
   {
      setShape();
      g2.setColor(shapeColor);
      Ellipse2D.Double ellipse = new Ellipse2D.Double(xTop, yTop, width, height);
      g2.fill(ellipse);
      //System.out.println("shape1:" + getXTop() + " " + getYTop() + " " +  getWidth() + " " +  getHeight());      
   }
   private void setShape()
   {
      setWidth(LONGSIDERATIO*r);
      setHeight(SHORTSIDERATIO*r);
      setTop();
      //System.out.println("shape1setShape()");
   }
   /*All get methods*/
   public double getX()
   {
      return x;
   }
   public double getY()
   {
      return y;
   }
   public double getR()
   {
      return r;
   }
   public Color getColor()
   {
      return shapeColor;
   }
   public double getShortSide()
   {
      return SHORTSIDERATIO;
   }
   public double getLongSide()
   {
      return LONGSIDERATIO;
   }
   public double getXTop()
   {
      return xTop;
   }
   public double getYTop()
   {
      return yTop;
   }
   public double getWidth()
   {
      return width;
   }
   public double getHeight()
   {
      return height;
   }
/*All set methods*/
   public void setX(double x)
   {
      this.x = x;
   }   
   public void setY(double y)
   {
      this.y = y;
   }   
   public void setR(double r)
   {
      this.r = r;
   }   
   public void setWidth(double width)
   {
      this.width = width;
   }
   public void setHeight(double height)
   {
      this.height = height;
   }
   public void setTop()
   {
      xTop = x-width/2;
      yTop = y-height/2;
   }
   public void setColor(Color color)
   {
      shapeColor = color;
   }

}
