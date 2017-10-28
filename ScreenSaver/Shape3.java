/**
   COPYRIGHT (C) 2013 Zeal Yim. All Rights Reserved.
   CPSC1181 ObjectOrientated
   Lab #5
   @version 4.2
   @author Zeal Yim
   @date 10/15/2013
*/
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;


public class Shape3 extends Shape2
{
   private final int SIDERATIO = 3;

   public Shape3()
   {

   }
   /*constructor for Shape3*/   
   public Shape3(double x, double y, double r)
   {
      setX(x);
      setY(y);
      setR(r);
      randomColor();
   }
   private void setShape()
   {
      setWidth(SIDERATIO*getR());
      setHeight(SIDERATIO*getR());
      setTop();
      //System.out.println("shape3setShape()");
   }   
   public void draw (Graphics2D g2)
   {
      setShape();
      g2.setColor(getColor());
      Rectangle2D.Double square = new Rectangle2D.Double(getXTop(), getYTop(), getWidth(), getHeight());
      g2.fill(square);
      //System.out.println("shape3:" + getXTop() + " " + getYTop() + " " +  getWidth() + " " +  getHeight());
      super.draw(g2);
   }
}