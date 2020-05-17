package Formes;
/*
 * format generale d'une figure
 */

import Commande.SpecificCommand;

public interface  FormeGeometrique  {

	/*
	 * deplacement d'une figure en abcisse et ordonnées
	 */
	public abstract void move(double dx, double dy);
}
