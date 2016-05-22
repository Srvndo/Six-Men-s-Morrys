package testy;

import java.util.Scanner;

import org.jpl7.Query;

public class prueba 
{
	public static int[] insert(int t[])
	{
		int x; int j;
		for(int i = 0; i < 6; i++)
		{
			x = t[i];
			j = i - 1; 
			while(j >= 0 && x < t[j])
			{
				t[j+1] = t[j];
				j = j - 1;
			}
			
			t[j+1] = x;
		}
		return t;
	}
	/*public static void main(String []args)
	{
		
		Query q = new Query("consult('Six Mens Morris.pl')");
		q.hasSolution();
		
		Query q1 = new Query("linea(q" + 15 + ",q" + 16 + ",q" + 14 + ")");
		System.out.println(q1.hasSolution());
	}*/


}
