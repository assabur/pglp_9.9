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
	private static  HashMap<String,Commande>listedescommande=new HashMap<String, Commande>();
	public static HashMap<String, Commande> getListedescommande() {
		return listedescommande;
	}

	
	
	/**
	 * Recupere le nom et la commande et les arguments de la commande
	 * ecrite par l'utilisateur 
	 * @param Str
	 */
	public List<String> decoupeChaine(String Str) 
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
	public Commande executeCommand (String name,List<String> parametre) 
	{	
		Commande usercommand = listedescommande.get(name);
	        	if(usercommand!=null)
	        	{
	        		//System.out.println("dans execute commande");
		        	usercommand.execute(parametre);	
		        	return usercommand;
	        	}
	        	//Flash.affiche("commande non valide "+name);
	        	return  null;
	              
	}
	
	/*
	 * methode permettant d'ajouter une commande avec ces differents parametres 
	 */
	public void addCommand(String name,Commande commande)
	{		
		this.listedescommande.put(name, commande);
		//System.out.println(name);
	}	

	
	
		/**
		 * Initialise les commandes
		 */
		public void init() 
		{
			/*
			 * mes differentes commandes
			 */
			 Receiver_Formes receiver=new Receiver_Formes();
			 CmdQuit quitprog=new CmdQuit(receiver);
			 CmdCercle Cercle=new CmdCercle(receiver);
			 CmdRectangle Rectangle=new CmdRectangle(receiver);
			 CmdCarre Carre=new CmdCarre(receiver);		
			 CmdTriangle Triangle=new CmdTriangle(receiver);
			 CmdCompose compose=new CmdCompose(receiver);
			 CmdMove Move=new CmdMove(receiver);
			 CmdShow affich=new CmdShow(receiver);
			 CmdHelp help=new CmdHelp(receiver);
				
			
			this.addCommand("show", affich);
			this.addCommand("cercle", Cercle);
			this.addCommand("rectangle", Rectangle);
			this.addCommand("triangle", Triangle);
			this.addCommand("carre", Carre);
			this.addCommand("move", Move);			 
			this.addCommand("quit", quitprog);
			this.addCommand("compose", compose);
			this.addCommand("help",help);
			
		}
	
}
