package Commande;

import java.util.List;

public class CmdShow implements GenericCommande
 {
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdShow(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List<String> parametre) 
	{
		
	}
}
