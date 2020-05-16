package fr.uvsq.solid.pglp_9;

public class Carre extends FormeGeometrique{
	/** Coordonné du coin superieur gauche */
	private Point upLeft;

	/** Coordonnes du coin inferieur droit */
	private Point upRight;

	/**
	 * Initialise le carre.
	 * 
	 * @param upLeft
	 *            Le coin superieur gauche.
	 * @param downRight
	 *            Le coin inferieur droit.
	 */
	public Carre(Point upLeft, Point upRight) {
		
		this.upLeft = upLeft;
		this.upRight = upRight;
	}

	/**
	 * Translate le carre.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnes.
	 */
	@Override
	public void translate(double dx, double dy) {
		upLeft.translate(dx, dy);
		upRight.translate(dx, dy);
	}

	/**
	 * Retourne une chaine representant l'objet.
	 * 
	 * @return la chaïne.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		str.append(upLeft.toString());
		str.append(", ");
		str.append(upRight.toString());
		str.append("]");
		return str.toString();

}

	public void execute() {
		// TODO Auto-generated method stub
		
	}}
