package fr.uvsq.solid.pglp_9;

import java.util.Scanner;

import Commande.Interpreter;
import DessinException.ErreurCommandeException;

public class DrawingTUI 
{
	private Interpreter interpreter=new Interpreter();
	private Scanner reponse=new Scanner(System.in);
	/*
	 * on recupere la saisie de l'user tout en verifiant ci il sagit bien d'une commande valide
	 * 
	 */
	public void nextCommand() throws ErreurCommandeException
	{		 	
	do{
		String saisie="";
		 System.out.println("Dessin>");
		 saisie=reponse.nextLine();
		if(!interpreter.isMatching(saisie))
			throw new ErreurCommandeException();
		interpreter.executeCommand(saisie);
	}while(true); 
	
	}
	
	public void shwow()
	{
		
	}
	

}
