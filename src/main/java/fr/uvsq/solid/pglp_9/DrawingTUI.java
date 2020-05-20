package fr.uvsq.solid.pglp_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Commande.Commande;
import Commande.Interpreter;

import Commande.VerificationSaisie;
import DessinException.ErreurCommandeException;

public class DrawingTUI 
{
	//j'initialise l'ensemble de mes commandes
	private Interpreter interpreter=Interpreter.init();
	//c1=cercle((1,1),2)
	private List<String> parametre=new ArrayList<String>();
	
	/*
	 * on recupere la saisie de l'user tout en verifiant ci il sagit bien d'une commande valide
	 * 
	 */
	public Commande nextCommand(String chaineUser) 
	{	
		String Commandename="";
		if(VerificationSaisie.verificationSaisieUser(chaineUser))
		{
			//interpreter.afficheCommande();
			this.parametre = interpreter.DecoupeChaine(chaineUser);
			Commandename=this.parametre.get(1);
			//Flash.affiche(Commandename.toLowerCase());
			return interpreter.executeCommand(Commandename.toLowerCase(),this.parametre);		
			}
		else
		{
			Flash.affiche("commande non valide next");
			return null;
		}		
	}
	public void show(String name)
	{
		if (parametre.get(0).toLowerCase().contentEquals("show") == false
				&& parametre.get(0).toLowerCase().contentEquals("quit") == false) {
			this.parametre = this.parametre.subList(0, 1);
			this.parametre.add(this.parametre.get(0));
			try {
			//	AfficheFig.affich(ContFig.get());
			} catch (Exception e) {
				System.out.println("exception a gerer dans affich");
			}	
	}
}}
