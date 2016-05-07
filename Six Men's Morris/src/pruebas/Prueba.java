package pruebas;
import java.util.Map;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import java.util.Scanner;

public class Prueba 
{
	static Scanner keyboard = new Scanner(System.in);
	
	public void checkTresEnLinea(Ficha[] f)
	{
		Query q = new Query("consult('Six Mens Morris.pl')");
		System.out.println(q.hasSolution());
		
		Query verificar;
	}
	
	public void insertarFichas(Ficha[] f)
	{
		for(int i = 0, k = 6; i < 6; i++, k++)
		{
			if(f[i].getEstado().compareTo("") == 0)
			{
				System.out.println("Ingrese la posicion de la ficha " + i + " : ");
				f[i].setEstado("q" + keyboard.nextLine());
				System.out.println("Ingresado: " + f[i].getEstado());
			}
			checkTresEnLinea(f);
			
			if(f[k].getEstado().compareTo("") == 0)
			{
				System.out.println("Ingrese la posicion de la ficha " + k + " : ");
				f[k].setEstado("q" + keyboard.nextLine());
				System.out.println("Ingresado: " + f[k].getEstado());
			}
		}
	}

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		Prueba p = new Prueba();
		Ficha f[] = new Ficha[12];
		for(int i = 0; i < 12; i++)
			f[i] = new Ficha("F" + (i+1));
		/* System.out.println(f[11].getNombre());
		Query q = new Query("consult('Six Mens Morris.pl')");
		
		System.out.println("Es: " + (q.hasSolution() ? "Correcto" : "Falso"));
		
		Query q1 = new Query("linea(q1,q2,q3)");
		System.out.println("Es: " + q1.hasSolution());
		*/
		p.insertarFichas(f);
	}

}
