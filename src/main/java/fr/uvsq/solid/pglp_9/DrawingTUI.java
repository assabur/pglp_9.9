package fr.uvsq.solid.pglp_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Commande.Commande;
import Commande.Interpreter;

import Commande.VerificationSaisie;
import DessinException.ErreurCommandeException;

public class DrawingTUI {
	// j'initialise l'ensemble de mes commandes
	private Interpreter interpreter = new Interpreter();
	// c1=cercle((1,1),2)
	protected static List<String> parametre = new ArrayList<String>();

	public void init() {
		interpreter.init();
	}

	/*
	 * on recupere la saisie de l'user tout en verifiant ci il sagit bien d'une
	 * commande valide
	 * 
	 */
	public Commande nextCommand(String chaineUser) {
		String commandename = "";
		Commande cmd;

		if (VerificationSaisie.verificationSaisieUser(chaineUser))

		{
			this.parametre = interpreter.DecoupeChaine(chaineUser);
			if (chaineUser.toLowerCase().contains("move")||chaineUser.toLowerCase().contains("show") || chaineUser.toLowerCase().contains("quit")
					|| chaineUser.toLowerCase().contentEquals("help")) {
				commandename = this.parametre.get(0);
			} else {
				commandename = this.parametre.get(1);
			}

			return interpreter.getListedescommande().get(commandename.toLowerCase());
		} else {
			Flash.affiche("syntaxe non valide ");
			return null;
		}

	}

	public void show(String name) {
		if (parametre.get(0).toLowerCase().contentEquals("show") == false
				&& parametre.get(0).toLowerCase().contentEquals("quit") == false) {
			this.parametre = this.parametre.subList(0, 1);
			this.parametre.add(this.parametre.get(0));
			/*
			 * try { // AfficheFig.affich(ContFig.get()); } catch (Exception e)
			 * { Flash.affiche("exception a gerer dans affich"); }
			 */
		}
	}
}
