package Commande;

import java.util.List;

public class CmdMove implements GenericCommande {
	
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdMove(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	
	public void execute(List<String> parametre)
	{
	
	}
}
