package DessinException;

import fr.uvsq.solid.pglp_9.Flash;

public class NomDeFigureInValide  extends Exception{

	public NomDeFigureInValide() {
		Flash.affiche("Nom de figure invalide");
	}

}
