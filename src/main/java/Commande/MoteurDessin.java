package Commande;

import java.util.HashMap;

import Formes.Carre;
import Formes.Cercle;
import Formes.Point;
/*
 * classe constitituant le coeur de lappli en effet il contient la methode init qui permet
 *  d'initialiser l'ensemble des commandes
 */
public class MoteurDessin 
{
	
	//private static GenericCommande genericProg;
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
