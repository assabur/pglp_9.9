package Formes;

public class Carre implements FormeGeometrique{
	/** Coordonné du coin superieur gauche */
	private Point upLeft;

	/** Coordonnes du coin inferieur droit */
	private Point upRight;
	
	private String nom; 

	/**
	 * Initialise le carre.
	 * 
	 * @param upLeft
	 *            Le coin superieur gauche.
	 * @param downRight
	 *            Le coin inferieur droit.
	 */
	public Carre(String nom,Point upLeft, Point upRight) {
		
		this.upLeft = upLeft;
		this.upRight = upRight;
		this.nom=nom;
	}

	/**
	 * Translate le carre.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnes.
	 */

	public void move(double dx, double dy) {
		upLeft.move(dx, dy);
		upRight.move(dx, dy);
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
		str.append(upRight.toString());
		str.append(")");
		return str.toString();

}

	public void execute() {
		// TODO Auto-generated method stub
		
	}}
