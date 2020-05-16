package Commande;

import java.util.HashMap;

import Formes.Carre;
import Formes.Cercle;
import Formes.Point;

public class MoteurDessin {
	private Interpreter interpreteur=new Interpreter();
	private  HashMap<String, Point> parametrePoint;
	private  HashMap<String, String> parametreVariable;
	private  HashMap<String, Double> parametreValeur;
	
	public MoteurDessin(HashMap<String, Point> parametrePoint,HashMap<String, String> parametreVariable,HashMap<String, Double> parametreValeur)
	{
		this.parametrePoint=parametrePoint;
		this.parametreValeur=parametreValeur;
		this.parametreVariable=parametreVariable;
	}

	  public void init ()  
		{	
			this.interpreteur.addCommand("cercle",					
					new Cercle(parametreVariable.get("nom"),parametrePoint.get("centreCercle"),parametreValeur.get("rayon")));	
			
			this.interpreteur.addCommand("carre",					
					new Carre (parametreVariable.get("nom"),parametrePoint.get("upLeft"),parametrePoint.get("upRight")));
			
			this.interpreteur.addCommand("triangle",					
					new Cercle(parametreVariable.get("nom"),parametrePoint.get("centreCercle"),parametreValeur.get("rayon")));
			
			this.interpreteur.addCommand("rectangle",					
					new Cercle(parametreVariable.get("nom"),parametrePoint.get("centreCercle"),parametreValeur.get("rayon")));			
		}
  
}
