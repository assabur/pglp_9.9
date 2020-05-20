package Formes;

import java.io.Serializable;

public class Cercle extends FormeGeometrique implements Serializable{

	/** Le centre du cercle. */
	private Point center;

	/** Le rayon du cercle */
	private int radius;
	
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
	public Cercle(String nom,Point center, int radius)
	{
		this.center = center;
		this.radius = radius;
		this.nom=nom;
	}

	/**
	 * Renvoie le rayon du cercle.
	 * 
	 * @return le rayon du cercle.
	 */
	public int getRadius() {
		return radius;
	}
	/*
	 * retourne le nom de la variable(du cercle)
	 */
	public String getname() {
		return nom;
	}


	/**
	 * Translate le cercle.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnes.
	 */
	
	public void move(int dx, int dy) {
		center.move(dx, dy);
	}

	/**
	 * Retourne une chaïne décrivant le cercle.
	 * 
	 * @return la representation textuelle du cercle.
	 */
	public String toString() {
	
		StringBuilder str = new StringBuilder();
		str.append(nom);
		str.append("(cercle= centre");
		str.append(center.toString());
		str.append(", Rayon(");
		str.append(radius);
		str.append("))");
		return str.toString();
		
	}

	public void execute() 
	{
			
		
	}
}
