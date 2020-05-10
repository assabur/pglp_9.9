package fr.uvsq.solid.pglp_9;

import java.util.Scanner;

public class DrawingTUI 
{
	Interpreter interpreter=new Interpreter();
	Scanner reponse=new Scanner(System.in);
	public void nextCommand()
	{		 	
		 String saisie="";
		 System.out.println("Dessin>");
		 saisie=reponse.nextLine();
		 //je recupere la commande a effectué apres avoir interpreté la saisie de l'user
		// interpreter.testcommand(saisie);
	}
	
	public void shwow()
	{
		
	}
	

}
