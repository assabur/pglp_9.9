package Formes;
/*
 * format generale d'une figure
 */

import Commande.SpecificCommand;

public abstract class FormeGeometrique implements SpecificCommand {

	/*
	 * deplacement d'une figure en abcisse et ordonnées
	 */
	public abstract void translate(double dx, double dy);
}
