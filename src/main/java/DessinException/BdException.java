package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class BdException extends Exception {

	public BdException() {
		Flash.affiche("Acces refusé a la BD ");
	}

}
