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
import fr.uvsq.solid.pglp_9.Flash;
/*
 * Interprete les commandes entre par l'user
 */
public class Interpreter 
{
	/*
	 * Liste des commandes possibles
	 */
	private final HashMap<String, Commande>listedescommande=new HashMap<String, Commande>();
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
	public void executeCommand (String name,List<String> parametre) 
	{
	        try {
	        	Commande usercommand = listedescommande.get(name);
	        	usercommand.execute(parametre);	 
			} catch (Exception e) {
				Flash.affiche("commande non valide");
			}
	              
	}
	
	/*
	 * methode permettant d'ajouter une commande avec ces differents parametres 
	 */
	public void addCommand(String name,Commande commande)
	{		
		this.listedescommande.put(name, commande);
	}	
	public void afficheCommande()
	{
		
		System.out.println(listedescommande.get("carre"));
		System.out.println(listedescommande.get("cercle"));
	}
	
	
	//mes differentes commandes
		private static CmdQuit quitprog;
		private static CmdCercle Cercle;
		private static CmdRectangle Rectangle;
		private static CmdCarre Carre;
		private static CmdTriangle Triangle;
		private static Receiver_Formes receiver;
		private static CmdMove Move;
		private static CmdShow affich;
		

		/**
		 * Initialise les commandes
		 */
		public static Interpreter init() 
		{
			Interpreter interpreteur = new Interpreter();			
			quitprog=new CmdQuit(receiver);
			Cercle = new CmdCercle(receiver);
			Rectangle = new CmdRectangle(receiver);
			Triangle = new CmdTriangle(receiver);
			Carre=new CmdCarre(receiver);
			Move = new CmdMove(receiver);
			affich = new CmdShow(receiver);
			interpreteur.addCommand("cercle", Cercle);
			interpreteur.addCommand("rectangle", Rectangle);
			interpreteur.addCommand("triangle", Triangle);
			interpreteur.addCommand("carre", Carre);
			interpreteur.addCommand("move", Move);
			interpreteur.addCommand("show", affich);
			interpreteur.addCommand("quit", quitprog);

			return interpreteur;
		}
	
}



