package Commande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DessinException.ErreurCommandeException;
import DessinException.StringException;
import Formes.Point;

public class Interpreter 
{

	
	/**
	 * format generale pour la creation de figure nom = commande
	 */
	private static final String expressionReguliereCommande = ".+=.+";
	private static final Pattern pattern = Pattern.compile(expressionReguliereCommande);
	//collection contenant la liste des commandes 
	protected  HashMap<String, Commande> listedescommande=new HashMap<String, Commande>();
	//parametre des commandes entrés
	protected HashMap<String, Point> parametrePoint=new HashMap<String, Point>();
	//parametre contenant les valeurs
	protected HashMap<String, Double> parametreValeur=new HashMap<String,Double>();
	//parametre variable
	protected HashMap<String, String> parametreVariable=new HashMap<String, String>();
	
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
	 * @throws ErreurCommandeException 
	 */
	public boolean isMatching(String text) throws ErreurCommandeException  {
		Matcher matcher = pattern.matcher(text);
		if(matcher.matches())
			matcher = patterncercle.matcher(text);
	    	if(matcher.matches())//il sagit d'un cercle
	    	{	/*je choisis de creeer une collection qui specifie les parametres de l'objet a creer
	    		 * par exemple pour un cercle on a :
	    		* 		nom de ma figure=c1
	    				commande		=Cercle
	    				abcisse du centre=01
	    				ordonne du centre=11
	    				rayon du cercle=51

	    		*/
	
	    		parametreVariable.put("variable", this.Stringsplit(text).get(0));
	    		parametreVariable.put("nom", this.Stringsplit(text).get(1));	    		
	    		parametrePoint.put("centreCercle", new Point
	    				(Double.parseDouble(this.Stringsplit(text).get(2)),
	    						Double.parseDouble(	this.Stringsplit(text).get(3) )));
	    		
	    		parametreValeur.put("rayon",Double.parseDouble( this.Stringsplit(text).get(4)));
	    		
	    		//apres avoir decomposé le texte saisi par l'user je lance la fonction init pour initialiser les commandes
	    		MoteurDessin moteur=new MoteurDessin(parametrePoint, parametreVariable, parametreValeur);
	    		moteur.init();	    		
	    		//ensuite j'execute la commande taper taper l'user
	    		this.executeCommand(parametreVariable.get("nom"));
	    		
	    		
	    		
	    		return true;
	    	}
	    	else {
	    		matcher = patternrectcarre.matcher(text);
	    		if(matcher.matches())
	    			return true;//il sagit d'un carre
	    		else {
	    			matcher = patterntriangle.matcher(text);
	    			if(matcher.matches())
	    				return true;//il sagit dun triangle
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
	 * de l'executer en prenant en compte les differents parametres en entrés
	 */
	public void executeCommand (String name) throws ErreurCommandeException
	{
		//System.out.println("entrer dans execute");
		 Commande usercommand = listedescommande.get(name);
	        if (usercommand == null) {
	        	throw new  ErreurCommandeException();            
	        }
	        usercommand.execute();
	       
	}
	/*
	 * methode permettant d'ajouter une commande avec ces differents parametres 
	 */
	public void addCommand(String name,Commande commande)
	{		
		this.listedescommande.put(name, commande);
	}	
	
}
