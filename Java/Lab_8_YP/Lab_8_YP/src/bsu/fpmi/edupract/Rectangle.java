package bsu.fpmi.edupract;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Canvas {

	private static final long serialVersionUID = 1L;
	private double height;
	private double width;
	private Color color;
		
	public Rectangle() {
		this.height = 10.0;
		this.width = 10.0;
		this.color = new Color(0,0,0);
	}
	
	public Rectangle(double height, double width, Color color) {
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
    public void paint(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
    	double a, b;
    	a = g.getClipBounds().getWidth();
    	b = g.getClipBounds().getHeight();
      	Shape Rectangle = new Rectangle2D.Double(a/2-this.height/2, b/2-this.width/2, this.width, this.height);
    	g2.setColor(this.color);
    	g2.draw(Rectangle);
    	g2.fill(Rectangle);
    }
	
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
        
    }
   
    public double getRectWidth() 
    {
        return this.width;
    }
    
    public double getRectHeight() {
        return this.height;
    }

    public Color getRectColor() {
        return this.color;
    }
}
