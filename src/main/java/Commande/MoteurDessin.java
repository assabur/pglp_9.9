package Commande;

import java.util.HashMap;

import Formes.Carre;
import Formes.Cercle;
import Formes.Point;

public class MoteurDessin {
	


	private static GenericCommande genericProg;
	private static GenericCommande quitprog;

	private static SpecificCommand Cercle;
	private static SpecificCommand Rectangle;
	private static SpecificCommand carre;
	private static SpecificCommand Triangle;
	private static Receiver_Formes receiver;
	private static CmdMove move;
	private static CmdShow affich;

	/**
	 * Initialise les commandes
	 */
	public static Interpreter init() 
	{
		Interpreter inter = new Interpreteur();

		genericProg=new Generic();
		quitprog = new CommandQuit(genericProg);

		receiver = new Specific();

		createCercle = new CommandeCercle(receiver);

		createRectangle = new CommandRectangle(receiver);

		createTriangle = new CommandTriangle(receiver);

		move = new CommandMove(receiver);

		affich = new CommandAffichage(receiver);

		inter.register("quit", quitprog);
		inter.register("cercle", createCercle);
		inter.register("rectangle", createRectangle);
		//inter.register("carre", createFig);
		inter.register("triangle", createTriangle);
		//inter.register("groupe", createFig);
		inter.register("move", move);
		inter.register("affiche", affich);

		return inter;
	}
	 
  
}
