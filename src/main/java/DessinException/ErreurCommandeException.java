package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class ErreurCommandeException extends Exception {
	
	public ErreurCommandeException(String message)
	{
		Flash.affiche("Warning: "+message);
	}

}
