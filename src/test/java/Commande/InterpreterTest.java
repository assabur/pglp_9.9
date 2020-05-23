package Commande;

import org.junit.Before;
import org.junit.Test;

import Commande.Interpreter;
import DessinException.ErreurCommandeException;
import fr.uvsq.solid.pglp_9.DrawingTUI;

public class InterpreterTest {

	private Interpreter  interpreter=new Interpreter();
	private DrawingTUI drawing= new DrawingTUI();
	@Before
	public void setup()
	{
		//
		interpreter=new Interpreter();
	
		
		
	}
	/*@Test
	public void validation_cercle() throws ErreurCommandeException
	{	
		if(interpreter.isMatching("c1=Cercle((01,11),51)"))
		{
			for(String a: interpreter.Stringsplit("c1=Cercle((01,11),51)"))
			{
				System.out.println(a);;
			}
		}
	}
	*/
	@Test
	public void testNextCommand() throws ErreurCommandeException
	{	
		//drawing.nextCommand();
	
	}
}
