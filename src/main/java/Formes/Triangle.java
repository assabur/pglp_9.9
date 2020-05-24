package Formes;

import java.io.Serializable;

public class Triangle extends FormeGeometrique implements Serializable{

	
	private String name;
	private Point downLeft;
	private Point downRight;
	private Point sommet;

	/**
	 * Initailise un triangle
	 * @param name Le nom du Triangle
	 * @param sommet Le sommet du triaangle
	 * @param downLeft le point a l'angle bas gauche du triangle
	 * @param downRight le point a l'angle bas droit du triangle
	 */
	public Triangle(String name, Point sommet, Point downLeft, Point downRight) {
		this.name = name;
		this.sommet=sommet;
		this.downLeft = downLeft;
		this.downRight = downRight;
	}


	/**
	 *donne la description d'un cercle.
	 * @return en chaine de caractere la description
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(" (triangle=>");
		str.append(sommet.toString()+", ");
		str.append(downLeft.toString());
		str.append(", ");
		str.append(downRight.toString());		
		str.append(")");
		return str.toString();
	}

	/**
	 * Retourne le nom du triangle
	 * @return le Nom
	 */
	public String getName() {
		return name;
	}

	/**
	 * retourne le point bas gauche du triangle
	 * @return Un point
	 */
	public Point getDownLeft() {
		return downLeft;
	}

	/**
	 * retourne le point bas droite du triangle
	 * @return Un point
	 */
	public Point getDownRight() {
		return downRight;
	}

	/**
	 * retourne le sommet du triangle
	 * @return Un point
	 */
	public Point getSommet() {
		return sommet;
	}


	public void move(int dx, int dy) {
		this.sommet.move(dx, dy);
		downLeft.move(dx, dy);
		downRight.move(dx, dy);
		
	}
	

}
