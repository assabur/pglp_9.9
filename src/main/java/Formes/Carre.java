package Formes;

import java.io.Serializable;

public class Carre extends FormeGeometrique implements Serializable{
	/** Coordonné du coin superieur gauche */
	private Point upLeft;

	/** Coordonnes du coin inferieur droit */
	private int cote;
	
	private String nom; 

	/**
	 * Initialise le carre.
	 * 
	 * @param upLeft
	 *            Le coin superieur gauche.
	 * @param downRight
	 *            Le coin inferieur droit.
	 */
	public Carre(String nom,Point upLeft, int cote) {
		
		this.upLeft = upLeft;
		this.cote = cote;
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Translate le carre.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnes.
	 */

	public void move(int dx, int dy) {
		upLeft.move(dx, dy);
		
	}

	/**
	 * Retourne une chaine representant l'objet carre
	 * 
	 * @return la chaïne.
	 */
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		str.append(nom);
		str.append("(carre=");
		str.append(upLeft.toString());
		str.append(", ");
		str.append(cote);
		str.append(")");
		return str.toString();
}
}
