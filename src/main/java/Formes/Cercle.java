package Formes;

public class Cercle extends FormeGeometrique {

	/** Le centre du cercle. */
	private Point center;

	/** Le rayon du cercle */
	private double radius;
	
	/*
	 * le nom du cercle
	 */
	
	private String nom;
	/**
	 * Initialise un cercle avec un centre et un rayon.
	 * 
	 * @param center
	 *            Le centre.
	 * @param radius
	 *            Le rayon.
	 */
	public Cercle(String nom,Point center, double radius) {
		this.center = center;
		this.radius = radius;
		this.nom=nom;
	}

	/**
	 * Renvoie le rayon du cercle.
	 * 
	 * @return le rayon du cercle.
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Translate le cercle.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnes.
	 */
	
	public void move(double dx, double dy) {
		center.translate(dx, dy);
	}

	/**
	 * Retourne une chaïne décrivant le cercle.
	 * 
	 * @return la representation textuelle du cercle.
	 */
	public String toString() {
	
		StringBuilder str = new StringBuilder();
		str.append(nom);
		str.append("(cercle=");
		str.append(center.toString());
		str.append(", ");
		str.append(radius);
		str.append(")");
		return str.toString();
		
	}

	public void execute() 
	{
			
		
	}
}
