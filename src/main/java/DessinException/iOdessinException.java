package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class iOdessinException extends Exception {

	public iOdessinException() 
	{
		Flash.affiche("Acces refusé tapez Help pour l'aide");
	}

}
