package fr.uvsq.solid.pglp_9;

import java.util.Scanner;
import Commande.Commande;
import DessinException.ErreurCommandeException;
/*
 * classe principale servant a lancer le projet
 */
public enum DrawingApp 
{
		THIS;
		public void run( String[] args) throws ErreurCommandeException
		{
			Scanner UserChaine;
			DrawingTUI saisie = new DrawingTUI();
			saisie.init();
			String chaine;		 
			do
			{
				Flash.affiche("Dessin>");
				UserChaine = new Scanner(System.in);	
				chaine = UserChaine.nextLine();
				Commande cmd;
				cmd = saisie.nextCommand(chaine);
				
				if(cmd!=null)
				{	
					cmd.execute(saisie.parametre);
				}
				else
					Flash.affiche("Commande non valide Tapez Help pour l'aide ");
				}while(true);
		}

		public static void main( String[] args ) throws ErreurCommandeException  {
			THIS.run(args);

		}
}
