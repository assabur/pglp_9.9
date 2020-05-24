package Formes;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.solid.pglp_9.Flash;

public class TriangleTest {

private static Point centre;
	
	private static Point p1;
	private static Point p2;
	private static Point p3;
	private static Triangle triangle;
	
	@Before public void setup()
	{
		p1= new Point(1,2);
		p2= new Point(4,2);
		p3= new Point(1,5);
		triangle=new Triangle("Montriangle ",p1,p2,p3);	
	}
	@Test
	public void testCercle() 
	{	
		Flash.affiche(triangle.toString());
	}
}
