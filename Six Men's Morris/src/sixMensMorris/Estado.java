package sixMensMorris;

import java.awt.*;
import javax.swing.*;

public class Estado extends JComponent {
	private String nombre;
	private int x, y;
	private boolean ocupado;
	
	Estado(String nombre, int x, int y){
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		ocupado = false;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean getOcup(){
		return ocupado;
	}
	
	public void setOcup(boolean ocupado){
		this.ocupado = ocupado;
	}

	public void paint(Graphics gg){
		
		super.paint(gg);
		if (gg instanceof Graphics2D){
		    Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // grosor de 5.0 pixels
		    
		    g2.drawOval(x, y, 10, 10);
		    g2.fillOval(x, y, 10, 10);
		 }
	}
}
