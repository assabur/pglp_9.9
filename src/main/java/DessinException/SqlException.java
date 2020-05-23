package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class SqlException extends Exception {

	public SqlException() {
		Flash.affiche("erreur de connection a la BD ");
	}

}
