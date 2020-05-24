package fr.uvsq.solid.pglp_9;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import Commande.Commande;
import DAO.ConnectionDerby;
import DessinException.ErreurCommandeException;
/*
 * classe principale servant a lancer le projet
 */
public class DrawingApp 
{
	//THIS;
	public void initBD() 
	{
		try {
			ConnectionDerby.connection();
			ConnectionDerby.CreationTableForme();
		} catch (Exception e) {
			Flash.affiche("initialisation de la BD non prise en charge");
		}

	}


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
		DrawingApp dessin = new DrawingApp();
		dessin.initBD();
		dessin.run(args);

	}
}
