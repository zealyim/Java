import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StarViewer
{
   private final static int FRAME_WIDTH = 1000;
   private final static int FRAME_HEIGHT = 800;
   private final static int INTERVAL = 200;
   public static void main (String[]args)
   {
    
      JFrame frame = new JFrame();
      
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Stars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      StarComponent component = new StarComponent(FRAME_WIDTH,FRAME_HEIGHT);

      class TimerListener implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("Timer!");
            component.repaint();
         }
      }
      ActionListener listener = new TimerListener();
      Timer t = new Timer(INTERVAL, listener);
      t.start();
      frame.add(component);

      frame.setVisible(true);
      
   }
}