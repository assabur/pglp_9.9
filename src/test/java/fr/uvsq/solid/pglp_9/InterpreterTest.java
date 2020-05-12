package fr.uvsq.solid.pglp_9;

import org.junit.Before;
import org.junit.Test;

public class InterpreterTest {

	private Interpreter  interpreter;
	
	@Before
	public void setup()
	{
		//
		interpreter=new Interpreter();
		
	}
	@Test
	public void validation_cercle()
	{	
		if(interpreter.isMatching("c1=Cercle((01,11),51)"))
		{
			Interpreter.Stringsplit("c1=Cercle((01,11),51)");
		}
	}
	
}
