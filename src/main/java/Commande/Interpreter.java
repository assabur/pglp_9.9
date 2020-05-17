package Commande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DessinException.ErreurCommandeException;
import DessinException.StringException;
import Formes.Cercle;
import Formes.Point;

public class Interpreter 
{

	/**
	 * format generale pour la creation de figure nom = commande
	 */
	private static final String regex = ".+=.+";
	private static final Pattern pattern = Pattern.compile(regex);

	/**
	 * format generale cercle nom = commande((nombre,nombre),nombre)
	 */
	private static final String regexcercle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*\\.?\\d+?\\s*"
			+ ",\\s*\\d*\\.?\\d+\\s*\\)\\s*,\\s*\\d*\\.?\\d+?\\s*\\)";
	private static final Pattern patterncercle = Pattern.compile(regexcercle);

	/**
	 * format generale rectangle et carre nom = commande((nombre,nombre),(nombre,nombre))
	 */
	private static final String regexrectcarre = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*"
			+ ",\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\."
			+ "?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternrectcarre = Pattern.compile(regexrectcarre);

	/**
	 * format generale triangle nom = commande((nombre,nombre),(nombre,nombre),(nombre,nombre))
	 */
	private static final String regextriangle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patterntriangle = Pattern.compile(regextriangle);

	/**
	 * forme general pour deplacer une figure
	 */
	private static final String regexmove = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-]+)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*,"
			+ "\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternmove = Pattern.compile(regexmove);

	private static final String regexaffiche = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-])+\\s*\\)";
	private static final Pattern patternaffiche = Pattern.compile(regexaffiche);

	private static final String regexgroup = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*(([a-zA-Z0-9_-]*\\s*+),*)+\\)";
	private static final Pattern patterngroup = Pattern.compile(regexgroup);
	private String text="";
	private static int TYPE;
	/**
	 * Verifie le format du text entrer par l'user
	 * @param text format enter par l'user
	 * @return true or false
	 * @throws ErreurCommandeException 
	 */
	public static boolean isMatching(String text)  {
		Matcher matcher = pattern.matcher(text);
		if(matcher.matches()) {//verifie si cest une creation
			TYPE = 1;
			matcher = patterncercle.matcher(text);
			if(matcher.matches())
				return true;
			else {
				matcher = patternrectcarre.matcher(text);
				if(matcher.matches())
					return true;
				else {
					matcher = patterntriangle.matcher(text);
					if(matcher.matches())
						return true;
					else {
						matcher = patterngroup.matcher(text);
						if(matcher.matches())
							return true;
					}
				}
			}

		}else {
			TYPE = 0;
			matcher = patternmove.matcher(text);
			if(matcher.matches()){
				return true;
			}else {
				matcher = patternaffiche.matcher(text);
				if(matcher.matches())
					return true;
			}
		}
		return false;
	}

	
	
	//public Commande commandeUser( String text) throws ErreurCommandeException
	{
		/*je choisis de creeer une collection qui specifie les parametres de l'objet a creer
		 * par exemple pour un cercle on a :
		* 		nom de ma figure=c1
				commande		=Cercle
				abcisse du centre=01
				ordonne du centre=11
				rayon du cercle=51

		*/
		/*this.text=text;
		Matcher matcher;// = pattern.matcher(text);
		matcher = patterncercle.matcher(text);
		if (matcher.matches())
		{	
			
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
		
				return new Cercle(parametreVariable.get("nom"),
						parametrePoint.get("centreCercle"), 
						parametreValeur.get("rayon"));
		}
		 return null;*/
	
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

	private HashMap<String, Commande>listedescommande=new HashMap<String, Commande>();
	/*
	 * methode qui permet une fois retrouver le nom d'une commande de
	 * de l'executer en prenant en compte les differents parametres en entrés
	 */
	public void executeCommand (String name,List<String> parametre) throws ErreurCommandeException
	{
		//System.out.println("entrer dans execute");
		 Commande usercommand = listedescommande.get(name);
	        if (usercommand == null) {
	        	throw new  ErreurCommandeException();            
	        }
	        usercommand.execute();
	       
	}
	
	
	/**
	 * retourne le type de la commande saisie par l'utilisateur
	 * @return TYPE
	 */
	public static int gettypeString() {
		return TYPE;
	}
	/*
	 * methode permettant d'ajouter une commande avec ces differents parametres 
	 */
	public void addCommand(String name,Commande commande)
	{		
		this.listedescommande.put(name, commande);
	}	
	
}



