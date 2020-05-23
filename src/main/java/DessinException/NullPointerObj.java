package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class NullPointerObj extends Exception {

	public NullPointerObj() 
	{
		Flash.affiche("Erreur :commande non intialisé ");
	}

}
