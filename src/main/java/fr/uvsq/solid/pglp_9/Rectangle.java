package fr.uvsq.solid.pglp_9;

public class Rectangle extends FormeGeometrique {
	/** Coordonné du coin superieur gauche */
	private Point upLeft;

	/** Coordonnes du coin inferieur droit */
	private Point downRight;

	/**
	 * Initialise le rectangle.
	 * 
	 * @param upLeft
	 *            Le coin superieur gauche.
	 * @param downRight
	 *            Le coin inferieur droit.
	 */
	public Rectangle(Point upLeft, Point downRight) {
		assert upLeft.getX() <= downRight.getX()
				&& upLeft.getY() >= downRight.getY();
		this.upLeft = upLeft;
		this.downRight = downRight;
	}

	/**
	 * Translate le rectangle.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnï¿½es.
	 */
	@Override
	public void translate(double dx, double dy) {
		upLeft.translate(dx, dy);
		downRight.translate(dx, dy);
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
		str.append(downRight.toString());
		str.append("]");
		return str.toString();

}}
