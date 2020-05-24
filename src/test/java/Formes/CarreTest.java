package Formes;
import org.junit.Before;
import org.junit.Test;
import fr.uvsq.solid.pglp_9.Flash;
/**
 * teste de la forme geometrique Carre
 * @author MAIGA
 *
 */
public class CarreTest {

	private static Point upLeft;
	private static int cote;
	private Carre carre;
	@Before
	public void setup()
	{
		upLeft= new Point(1,2);
		cote= 5;
		carre=new Carre("carre1",upLeft,cote);
	}
	@Test
	public void testCarre() 
	{

		Flash.affiche(carre.toString());	
	}

}
