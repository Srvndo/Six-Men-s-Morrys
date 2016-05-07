package pruebas;

public class Ficha 
{
	private int x;
	private int y;
	private String nombre;
	private String estado;
	private boolean tipoFicha;

	public Ficha(String nombre)
	{
		this.setNombre(nombre);
		estado = "";
	}
	
	public void setPosicion(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}

	public String getEstado() 
	{
		return estado;
	}

	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	
	
}
