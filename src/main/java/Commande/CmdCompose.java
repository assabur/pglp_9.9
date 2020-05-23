package Commande;

import java.util.ArrayList;
import java.util.List;

public class CmdCompose implements GenericCommande
{
	/***
	 * commentaire : je recupere l'ensemble des figure saisie par l'user pour 
	 * ensuite cree un objet qui vas les contenir
	 * format de la commande: compose(carre,rectangle,triangle)
	 */
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdCompose(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	
	@Override
	public void execute(List<String> parametre) {
				
		receiver.makeCompose(parametre);
	}
}
