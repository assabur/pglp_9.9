package Formes;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.solid.pglp_9.Flash;
/**
 * teste de forme geometrique Rectangle
 * @author MAIGA
 *
 */
public class RectangleTest {

	private static Point upLeft;
	private static Point upRight;
	private Rectangle rectangle;
	@Before
	public void setup()
	{
		upLeft= new Point(1,2);
		upRight=new Point(3,2);
		rectangle=new Rectangle("rect1",upLeft,upRight);
	}
	@Test
	public void testCarre() 
	{

		Flash.affiche(rectangle.toString());	
	}
}
