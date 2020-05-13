package fr.uvsq.solid.pglp_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter 
{

	
	/**
	 * format generale pour la creation de figure nom = commande
	 */
	private static final String expressionReguliereCommande = ".+=.+";
	private static final Pattern pattern = Pattern.compile(expressionReguliereCommande);
	//collection contenant la liste des commandes tapez par l'user
	//private  HashMap<String, Commande> listedescommande=new HashMap<String, Commande>();
	//parametre des commandes entrés
	protected HashMap<String, String> parametre=new HashMap<String, String>();
	
	/**
	 * format generale cercle nom = commande((nombre,nombre),nombre)
	 */
	private static final String expressionReguliereCercle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*\\.?\\d+?\\s*"
											+ ",\\s*\\d*\\.?\\d+\\s*\\)\\s*,\\s*\\d*\\.?\\d+?\\s*\\)";
	private static final Pattern patterncercle = Pattern.compile(expressionReguliereCercle);
	
	/**
	 * format generale rectangle et carre nom = commande((nombre,nombre),(nombre,nombre))
	 * c1=carre(4)
	 */
	private static final String expressionReguliereCarre = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*"
			                                   + ",\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\."
			                                   + "?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternrectcarre = Pattern.compile(expressionReguliereCarre);
	
	/**
	 * format generale triangle nom = commande((nombre,nombre),(nombre,nombre),(nombre,nombre))
	 */
	private static final String expressionReguliereTriangle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
											  + "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
											  + "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patterntriangle = Pattern.compile(expressionReguliereTriangle);
	
	/**
	 * Verifie le format du text entrer par l'user
	 * @param text format enter par l'user
	 * @return true or false
	 */
	public  boolean isMatching(String text)  {
		Matcher matcher = pattern.matcher(text);
		if(matcher.matches())
			matcher = patterncercle.matcher(text);
	    	if(matcher.matches())//il sagit d'un cercle
	    	{	
	    		/*je choisis de creeer une collection qui specifie les parametres de l'objet a creer
	    		 * par exemple pour un cercle on a :
	    		* 		nom de ma figure=c1
	    				commande		=Cercle
	    				abcisse du centre=01
	    				ordonne du centre=11
	    				rayon du cercle=51

	    		*/
	    		
	    		
	    		parametre.put("nom", this.Stringsplit(text).get(0));
	    		parametre.put("centre_x", this.Stringsplit(text).get(2));
	    		parametre.put("centre_y", this.Stringsplit(text).get(3));
	    		parametre.put("rayon", this.Stringsplit(text).get(4));
	    		return true;
	    	}
	    	else {
	    		matcher = patternrectcarre.matcher(text);
	    		if(matcher.matches())
	    			return true;
	    		else {
	    			matcher = patterntriangle.matcher(text);
	    			if(matcher.matches())
	    				return true;
		    }
	    }
		return false;
	}
	
	
	/**
	 * Recupere le nom et la commande et les arguments de la commande
	 * ecrite par l'utilisateur 
	 * @param Str
	 */
	public List<String>  Stringsplit(String Str) 
	{
		List<String> list = new ArrayList<String>(5);//je decompose la saisie de l'user
	
		
		Str = Str.replaceAll("\\s","");
		Str = Str.replaceAll("=","#");
		Str = Str.replaceAll("\\(","#");
		Str = Str.replaceAll("\\)","#");
		Str = Str.replaceAll(",","#");
        for (String val: Str.split("#"))
            	if(!val.equals("")) 
        {
            		//System.out.println(val);
            		list.add(val);
        }
        return list;
        
	}
	/*
	 * methode qui permet une fois retrouver le nom d'une commande de
	 * de l'executer
	 */
	public void executeCommand (String name,) 
	{
		//System.out.println("entrer dans execute");
		 Commande usercommand = listedescommande.get(name);
	        if (usercommand == null) {
	        	//System.out.println("erreur de commande");            
	        }
	        usercommand.execute();
	        //System.out.println("passe apres interpretreur");
	}
	/*
	 * methode permettant d'ajouter une commande avec ces differents parametres 
	 */
	public void addCommand(String name,HashMap<String, String> parametre)
	{		
		this.listedescommande.put(name, command);
	}	
	
}
