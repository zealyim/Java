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
import java.awt.Color;



public class Shape2 extends Shape1
{

   /*default constructor for Shape2, valuable x, y, and r have the same value as the default constructor for Shape1 */
   public Shape2()
   {

   }
   /*constructor for Shape2*/
   public Shape2(double x, double y, double r)
   { 
      setX(x);
      setY(y);
      setR(r);
   }
   private void setShape()
   {
      setWidth(getShortSide()*getR());
      setHeight(getLongSide()*getR());
      setTop();
      //System.out.println("shape2setShape()");
   }
   public void draw(Graphics2D g2)
   {
      setShape();
      g2.setColor(getColor());
      Ellipse2D.Double ellipse = new Ellipse2D.Double(getXTop(), getYTop(), getWidth(), getHeight());
      g2.fill(ellipse);
      //System.out.println("shape2:" + getXTop() + " " + getYTop() + " " +  getWidth() + " " +  getHeight());
      super.draw(g2);
      
   }
}