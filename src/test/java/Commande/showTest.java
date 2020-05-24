package Commande;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Formes.Cercle;
import Formes.Point;
import fr.uvsq.solid.pglp_9.Flash;

public class showTest {

	Interpreter interpreter;
	String chaine="show(c1)";
	List<String> parametre;
	String commandeName="";
	Commande command;
	@Before public void setup()
	{

		interpreter=new Interpreter();	
		parametre=interpreter.decoupeChaine(chaine);
		commandeName=parametre.get(0);
		interpreter.init();
	}
	@Test
	public void testshow() 
	{
		command=interpreter.executeCommand(commandeName, parametre);
		System.out.println(commandeName);		
		if(command !=null)		
			Flash.affiche("commande existante");
	}
}
