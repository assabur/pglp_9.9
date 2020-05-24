package Commande;

import java.util.ArrayList;
import java.util.List;

import DessinException.BdException;
import DessinException.iOdessinException;
import fr.uvsq.solid.pglp_9.Flash;

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

		try {
			receiver.makeCompose(parametre);
		} catch (BdException | iOdessinException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}	
	}
}
