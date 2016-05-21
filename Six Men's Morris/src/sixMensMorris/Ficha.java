package sixMensMorris;

import javax.swing.*;
import java.awt.*;

public class Ficha extends JComponent {
	private int x, y;
	private Color color;
	private String nombre;
	private Estado estado;
	private boolean uso;
	
	Ficha(String nombre, int x, int y, Color color){
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.color = color;
		uso = true;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public boolean getUso(){
		return uso;
	}
	
	public void setUso(Boolean ocupado){
		uso = ocupado;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void paint(Graphics gg){
		super.paint(gg);
		if (gg instanceof Graphics2D){
		    Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // grosor de 5.0 pixels
		    
		    g2.setColor(color);
		    g2.setColor(Color.BLACK);
		    g2.drawOval(x-10, y-10, 30, 30);
		    g2.setColor(color);
		    g2.fillOval(x-10, y-10, 30, 30);
		 }
	}
}
