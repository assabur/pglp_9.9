package Formes;

public class Triangle extends FormeGeometrique{

	
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
		str.append("(triangle=");
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


	public void execute() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move(double dx, double dy) {
		this.sommet.translate(dx, dy);
		downLeft.translate(dx, dy);
		downRight.translate(dx, dy);
	}

}
