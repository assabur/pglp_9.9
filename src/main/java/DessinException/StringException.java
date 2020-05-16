package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class StringException extends Exception {
	
	public  StringException()
	{
		Flash.affiche("convertion de chaine non valide");
	}


}
