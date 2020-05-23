package Commande;

import java.util.List;

import DessinException.NomDeFigureInValide;
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
		
		String toString=receiver.readForme(nomVariable);
		
		Flash.affiche(toString);
		
	}
}
