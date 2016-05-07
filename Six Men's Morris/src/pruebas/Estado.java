package pruebas;

import java.awt.Dimension;

public class Estado {
	private Dimension pos;
	private boolean ocupado;
	private String nombre;
	
	Estado(int x, int y, String nombre){
		pos = new Dimension(x,y);
		ocupado = false;
		this.nombre = nombre;
	}
	
	public void ocupar(){
		ocupado = true;
	}
}
