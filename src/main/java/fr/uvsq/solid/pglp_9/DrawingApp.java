package fr.uvsq.solid.pglp_9;

import java.util.Scanner;

import DessinException.ErreurCommandeException;
/*
 * classe principale servant a lancer le projet
 */
public enum DrawingApp 
{
		THIS;
		public void run( String[] args) 
		{
			Scanner UserChaine;
			DrawingTUI saisie = new DrawingTUI();
			String chaine;		 
			do
			{
				Flash.affiche("Dessin>");
				UserChaine = new Scanner(System.in);	
				chaine = UserChaine.nextLine();
				saisie.nextCommand(chaine);
				//UserChaine.close();
			}while(true);
		}

		public static void main( String[] args )  {
			THIS.run(args);

		}
}
