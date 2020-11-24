import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations
{
	private ArrayList<Circle> circles; //the circles to animate
	private int size;    //canvas width and height (will be square)
	private Random rng;     //use to make random numbers

	/** create a drawing pane of a particular size */
	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size    = s;
		rng     = new Random();

		//don't mess with this
		StdDraw.setCanvasSize(size, size); //set up drawing canvas
		StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
		StdDraw.setYscale(0, size);
	}
	public void drawCircle()
	{
	    for (int i = 0; i < circles.size();i++)
	    {
	       circles.get(i).draw(); 
	       }
	    
	   }
	   public void addCircle()
	   {
	       circles.add(new Circle(rng.nextInt(size-1),rng.nextInt(size-1),rng.nextInt(75),new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255))));
	       circles.add(new Circle(rng.nextInt(size-1),rng.nextInt(size-1),rng.nextInt(75),new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255))));
	       circles.add(new Circle(rng.nextInt(size-1),rng.nextInt(size-1),rng.nextInt(75),new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255))));
               drawCircle();
	   }
	   public void addCircle(int number)
	   {
	       for (int i = 0; i <= number; i++)
	       {
	          circles.add(new Circle(rng.nextInt(size-1),rng.nextInt(size-1),rng.nextInt(10),new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255))));

	       }
	       drawCircle();
	   }
	   public void noOverlapping(int number)
	   {
	       int i = 0;
	       while  (circles.size() < number)
	       {
	            i = 0;
	            boolean x = false;
	            Circle a = new Circle(rng.nextInt(size-1),rng.nextInt(size-1),rng.nextInt(100),new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255)));
                    for (int j = 0; j < circles.size(); j++)
                    {
                        if (circles.get(j).overlaps(a))
                        {
                            x = true;
                        }                       
                    }
                     if(!x)
                        {
                            circles.add(a);
                        }
	           }	           
	       drawCircle();
	   }
	   public void movingCircles()
	   {
	       addCircle();
	       for (int j = 0; j < circles.size(); j++)
	       {
	           circles.get(j).setVelocityX(rng.nextInt(5)+1);
	           circles.get(j).setVelocityY(rng.nextInt(5)+1);
	       }
	       int i = 0;
	       while (true)
	       {
	           drawCircle();
	           for (int j = 0; j < circles.size();j++)
	           {
	               circles.get(j).update();
	           }
	           StdDraw.show(10);
	           StdDraw.clear();
	       }
	           
	       }
	       public void removeClicked()
	       {
	           addCircle();	  
	              while (circles.size() >0)
	              {
	                  for (int i = circles.size()-1; i > 0; i--)
	                  {
	                 double mouseXPos = StdDraw.mouseX();
	                  double mouseYPos = StdDraw.mouseY();
	                  if(StdDraw.isMousePressed())
	                  {
	                     if (mouseXPos < circles.get(i).getX()+circles.get(i).getRadius()|| mouseXPos > circles.get(i).getX() - circles.get(i).getRadius())
	                 {
	                      if(mouseYPos < circles.get(i).getY() + circles.get(i).getRadius() || mouseYPos > circles.get(i).getX() - circles.get(i).getRadius())
	                     {
	                         circles.remove(i);
	                       drawCircle();
	                   }
	                  }
	                   }
	       
	               }

	   }
}
}

