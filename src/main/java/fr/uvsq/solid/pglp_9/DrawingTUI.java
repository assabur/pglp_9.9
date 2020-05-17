package fr.uvsq.solid.pglp_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Commande.Interpreter;
import DessinException.ErreurCommandeException;

public class DrawingTUI 
{
	private Interpreter interpreter=new Interpreter();
	private Scanner reponse=new Scanner(System.in);
	private List<String> parametre=new ArrayList<String>();
	/*
	 * on recupere la saisie de l'user tout en verifiant ci il sagit bien d'une commande valide
	 * 
	 */
	public void nextCommand() throws ErreurCommandeException
	{	
		String Commandename="";
		
	do{
		Flash.affiche("Dessin>");
		String saisie="";		
		saisie=reponse.nextLine();
		if(interpreter.isMatching(saisie))
		{
			this.parametre = interpreter.Stringsplit(saisie);
			Commandename=this.parametre.get(interpreter.gettypeString());
			interpreter.executeCommand(Commandename.toLowerCase(),this.parametre);
			if ( interpreter.gettypeString() == 1) 
			{
				//il sagit d'une creation
				//this.show("affiche");
			}
		else
		{
			throw new ErreurCommandeException();
		}
		
	}
	
	}while(true); 
	}
	
	public void show(String name)
	{
		parametre = this.parametre.subList(0, 1);//je recupere le nom de la commande
		
		parametre.add(parametre.get(0));
		//interpreter.executeCommand(name,parametre);

		//System.out.println("	->"+ContAllFig.get(name));
	}
	
	

}
