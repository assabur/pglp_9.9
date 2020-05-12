package fr.uvsq.solid.pglp_9;

import java.util.Scanner;

import DessinException.ErreurCommandeException;

public class DrawingTUI 
{
	Interpreter interpreter=new Interpreter();
	Scanner reponse=new Scanner(System.in);
	public void nextCommand() throws ErreurCommandeException
	{		 	
	do{
		String saisie="";
		 System.out.println("Dessin>");
		 saisie=reponse.nextLine();
		if(!interpreter.isMatching(saisie))
			throw new ErreurCommandeException();
	}while(true); 
	
	}
	
	public void shwow()
	{
		
	}
	

}
