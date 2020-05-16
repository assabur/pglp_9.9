package Commande;

import java.util.HashMap;

import Formes.Cercle;
import Formes.Point;

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
	  
	  
	  
	  public void apply_operation (String saisie ) 
		 { 
	 		// System.out.println("passe apply1");
	    	 this.interpreteur.executeCommand(saisie);
	    	// System.out.println("passe apply2");    	 
	     }   
	    

}
