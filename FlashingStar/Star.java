import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.BasicStroke;
/**
   A Star shape that can be positioned anywhere on the screen.
*/
public class Star
{
	
	private final static double FACTOR = 2.63;
	private final static double ALFA = 18*Math.PI/180;
	private final static double BETA = 54*Math.PI/180;
   private final int POINTSFORSTAR = 11;
   private final int STROKEWIDTH = 5;
   private final BasicStroke stroke = new BasicStroke(STROKEWIDTH);
	
	private final static double[] X = {0,Math.cos(BETA)/FACTOR, Math.cos(ALFA ),
                                            Math.cos(ALFA )/FACTOR,	Math.cos(BETA),0,
                                            -Math.cos(BETA),-Math.cos(ALFA)/FACTOR,
                                            -Math.cos(ALFA ),-Math.cos(BETA)/FACTOR,0};
                                            
   private final static double[] Y = {-1,-Math.sin(BETA)/FACTOR, -Math.sin(ALFA ),
                                            Math.sin(ALFA )/FACTOR,	Math.sin(BETA),1/FACTOR,
                                            Math.sin(BETA),Math.sin(ALFA )/FACTOR,
                                            -Math.sin(ALFA ),-Math.sin(BETA)/FACTOR,-1};
	
	private int[] xCoordOfStar; // x coordinates of the vertices of the star as pixel
	private int[] yCoordOfStar; // x coordinates of the vertices of the star as pixel			
									
	 /**
	Calculates the coordinates of a 5 points star 
	@param radius, the length in pixel of each arm of the star from its center 
	@param x the x coordinate of the center of the star
	@param y the y coordinate of the center of the star
	*/
   
   //create new star
   public Star (double radius, double x, double y)
   {
      setStartCoordinates(radius, x, y);
   }
   //set the coordinate of the star
	public void setStartCoordinates(double radius , double x, double y)
   {
		
		xCoordOfStar= new int[X.length];
		yCoordOfStar= new int[Y.length]; 
		for (int i=0; i<X.length; i++)
      {
			xCoordOfStar[i] = (int)(radius*X[i]+x);
			yCoordOfStar[i] = (int)(radius*Y[i]+y);
		}	
   }
   //draw the line of the star and fill the star shape
   public void drawLine (Graphics2D g2)
   {
      g2.setStroke(stroke);
      g2.drawPolyline(xCoordOfStar,yCoordOfStar,POINTSFORSTAR);      

   }
   public void drawShape (Graphics2D g2)
   {
      g2.fillPolygon(xCoordOfStar,yCoordOfStar,POINTSFORSTAR);
   }
}
