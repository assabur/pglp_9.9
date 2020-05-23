package Formes;

public class Rectangle extends FormeGeometrique {
	/** Coordonné du coin superieur gauche */
	private Point upLeft;

	/** Coordonnes du coin inferieur droit */
	private Point downRight;

	private String nom="";
	

	/**
	 * Initialise le rectangle.
	 * 
	 * @param upLeft
	 *            Le coin superieur gauche.
	 * @param downRight
	 *            Le coin inferieur droit.
	 */
	public Rectangle(String nom,Point upLeft, Point downRight) {
		assert upLeft.getX() <= downRight.getX()
				&& upLeft.getY() >= downRight.getY();
		this.upLeft = upLeft;
		this.downRight = downRight;
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Translate le rectangle.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnï¿½es.
	 */
	
	public void move(int dx, int dy) {
		upLeft.move(dx, dy);
		downRight.move(dx, dy);
	}

	/**
	 * Retourne une chaine representant l'objet.
	 * 
	 * @return la chaïne.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("nom");
		str.append("(rectangle");
		str.append(upLeft.toString());
		str.append(", ");
		str.append(downRight.toString());
		str.append(")");
		return str.toString();
}

	public void execute() {
		// TODO Auto-generated method stub
		
	}}
