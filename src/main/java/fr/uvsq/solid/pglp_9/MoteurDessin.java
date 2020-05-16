package fr.uvsq.solid.pglp_9;

import java.util.HashMap;

public class MoteurDessin {
	private Interpreter interpreteur=new Interpreter();

	  public void initCercle(HashMap<String, Point> parametrePoint,
			  HashMap<String, String> parametreVariable,
			  HashMap<String, Double> parametreValeur
			  )  
		{	
			this.interpreteur.addCommand("cercle",					
					new Cercle(parametrePoint.get("centreCercle"),parametreValeur.get("rayon")));
				 	
		}

}
