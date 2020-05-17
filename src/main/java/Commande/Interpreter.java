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
/*
 * Interprete les commandes entre par l'user
 */
public class Interpreter 
{
	/*
	 * Liste des commandes possibles
	 */
	private HashMap<String, Commande>listedescommande=new HashMap<String, Commande>();
	/**
	 * Recupere le nom et la commande et les arguments de la commande
	 * ecrite par l'utilisateur 
	 * @param Str
	 */
	public List<String> DecoupeChaine(String Str) 
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
	public void executeCommand (String name,List<String> parametre) throws ErreurCommandeException
	{
		//System.out.println("entrer dans execute");
		 Commande usercommand = listedescommande.get(name);
	        if (usercommand == null) {
	        	throw new  ErreurCommandeException();            
	        }
	        usercommand.execute(parametre);
	       
	}
	
	
	
	/*
	 * methode permettant d'ajouter une commande avec ces differents parametres 
	 */
	public void addCommand(String name,Commande commande)
	{		
		this.listedescommande.put(name, commande);
	}	
	
}



