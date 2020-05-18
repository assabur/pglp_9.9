package fr.uvsq.solid.pglp_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Commande.Interpreter;
import Commande.MoteurDessin;
import Commande.VerificationSaisie;
import DessinException.ErreurCommandeException;

public class DrawingTUI 
{
	private Interpreter interpreter=new Interpreter();
	//c1=cercle((1,1),2)
	private List<String> parametre=new ArrayList<String>();
	
	/*
	 * on recupere la saisie de l'user tout en verifiant ci il sagit bien d'une commande valide
	 * 
	 */
	public void nextCommand(String chaineUser) 
	{	
		String Commandename="";
		//j'initialise l'ensemble de mes commandes
		Interpreter.init();
		
		if(VerificationSaisie.verificationSaisieUser(chaineUser))
		{
			//interpreter.afficheCommande();
			this.parametre = interpreter.DecoupeChaine(chaineUser);
			Commandename=this.parametre.get(1);
			//Flash.affiche(Commandename.toLowerCase());
			interpreter.executeCommand(Commandename.toLowerCase(),this.parametre);
			if ( VerificationSaisie.gettypeString() == 1) 
				{
				
				}
			}
		else
		{
			Flash.affiche("commande non valide");
		}		
	}
	
	public void show(String name)
	{
		parametre = this.parametre.subList(0, 1);//je recupere le nom de la commande
		 
		parametre.add(parametre.get(0));
		
	}
	
	

}
