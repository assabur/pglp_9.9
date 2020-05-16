package fr.uvsq.solid.pglp_9;

import org.junit.Before;
import org.junit.Test;

import Commande.Interpreter;
import DessinException.ErreurCommandeException;

public class InterpreterTest {

	private Interpreter  interpreter=new Interpreter();
	
	@Before
	public void setup()
	{
		//
		interpreter=new Interpreter();
		
	}
	@Test
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
	

}
