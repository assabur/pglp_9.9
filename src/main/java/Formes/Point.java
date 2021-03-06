package Formes;

import java.io.Serializable;

public class Point extends FormeGeometrique implements Serializable {
	
	
	/** L'abscisse du point. */
	private int x;

	/** L'ordonné du point. */
	private int y;

	/**
	 * Initialise un point à partir de deux coordonnés.
	 * 
	 * @param x
	 *            l'abscisse du point.
	 * @param y
	 *            l'ordonne du point.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Renvoie l'abscisse du point.
	 * 
	 * @return l'abscisse du point.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Renvoie l'ordone du point.
	 * 
	 * @return l'ordonne du point.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Translation d'un point.
	 * 
	 * @param dx
	 *            deplacement en abscisse.
	 * @param dy
	 *            deplacement en ordonnï¿½es.
	 */
	public void move(int dx, int dy) 
	{
		x += dx;
		y += dy;
	}

	/**
	 * Retourne une chaine décrivant le point.
	 * 
	 * @return la représentation textuelle du point.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append('(');
		str.append(x);
		str.append(", ");
		str.append(y);
		str.append(')');
		return str.toString();
	}

	
}
