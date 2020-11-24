import java.util.*;
import java.awt.Color;
import java.lang.Math;
public class Circle
{
    private int x;
    private int y;
    private int radius;
    private Color color;
    private int dx;
    private int dy;
    public Circle(int xValue, int yValue, int newRadius, Color newColor)
    {
        x = xValue;
        y = yValue;
        radius = newRadius;
        color = newColor;
    }
      public Circle(int xValue, int yValue, int newRadius, Color newColor,int xPos, int yPos)
    {
        x = xValue;
        y = yValue;
        radius = newRadius;
        color = newColor;
        dx = xPos;
        dy = yPos;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getRadius()
    {
        return radius;
    }
    public void setVelocityX(int newX)
    {
        this.dx = newX;
    }
    public void setVelocityY(int newY)
    {
        this.dy = newY;
    }
    public void draw()
    {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x,y,radius);
    }
    public static void main(String[] args)
    {
        new Circle(0,0,1,new Color(255,0,0)).draw();
    }
    public boolean overlaps(Circle other)
    {
        double max = this.radius + other.radius;
        double distance = Math.sqrt(Math.pow(other.x-this.x,2) + Math.pow(other.y-this.y,2));
        if (distance <= max)
        {
            return true;
        }
        return false;   
    }
    public void update()
    {
        this.x = this.x + this.dx;
        this.y = this.y + this.dy;
        bounce();
    }
    public void bounce()
    {
        if(this.x > 600-this.radius)
        {
            this.dx = -this.dx;
        }
        if(this.y > 600-this.radius)
        {
            this.dy = - this.dy;
        }
        if(this.x < 0+this.radius)
        {
            this.dx = -this.dx;
        }
        if(this.y < 0+this.radius)
        {
            this.dy = -this.dy;
        }
    }
}