package Commande;

import java.util.List;

import Formes.FormeGeometrique;

public class CmdMove implements GenericCommande {
	
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdMove(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	/**
	 * move(c1(1,5))
	 */
	public void execute(List<String> parametre)
	{
		int dx=Integer.parseInt(parametre.get(2));
		int dy=Integer.parseInt(parametre.get(3));
		Object monObjet=receiver.makeMove(parametre);
		((FormeGeometrique)monObjet).move(dx, dy);
	}
}
