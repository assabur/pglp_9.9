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
	private final HashMap<String,Commande>listedescommande=new HashMap<String, Commande>();
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
	        	//System.out.println("dans execute commande  "+name);
	        	Commande usercommand = listedescommande.get(name);
	        	//System.out.println("avant execute");
	        	usercommand.execute(parametre);	 
	        	//System.out.println("dans execute commande  "+name);
			} catch (Exception e) {
				//System.out.println("dans catcch");
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
	/*public void afficheCommande()
	{	
		System.out.println(listedescommande.get("carre"));
		System.out.println(listedescommande.get("cercle"));
	}*/
	
	
		/**
		 * Initialise les commandes
		 */
		public  static Interpreter init() 
		{
			//mes differentes commandes
			 Receiver_Formes receiver=new Receiver_Formes();
			 CmdQuit quitprog=new CmdQuit(receiver);
			 CmdCercle Cercle=new CmdCercle(receiver);
			 CmdRectangle Rectangle=new CmdRectangle(receiver);
			 CmdCarre Carre=new CmdCarre(receiver);		
			 CmdTriangle Triangle=new CmdTriangle(receiver);
			
			 CmdMove Move=new CmdMove(receiver);
			 CmdShow affich=new CmdShow(receiver);
			Interpreter interpreteur = new Interpreter();			
			
			 interpreteur.addCommand("cercle", Cercle);
			 interpreteur.addCommand("rectangle", Rectangle);
			 interpreteur.addCommand("triangle", Triangle);
			 interpreteur.addCommand("carre", Carre);
			 interpreteur.addCommand("move", Move);
			 interpreteur.addCommand("show", affich);
			 interpreteur.addCommand("quit", quitprog);
			 interpreteur.addCommand("compose", quitprog);
			return interpreteur;
		}
	
}
