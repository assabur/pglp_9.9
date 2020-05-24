package Commande;

import java.util.List;

import DessinException.BdException;
import DessinException.ErreurCommandeException;
import DessinException.NomDeFigureInValide;
import DessinException.iOdessinException;
import fr.uvsq.solid.pglp_9.Flash;

public class CmdShow implements SpecificCommand
{
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdShow(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List<String> parametre) 
	{	
		String nomVariable=parametre.get(1);
		String toString="";
		try {
			toString=receiver.readForme(nomVariable);
			Flash.affiche(toString);
		} catch (BdException | iOdessinException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		

	}
}
