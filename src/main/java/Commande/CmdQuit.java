package Commande;

import java.util.List;

public class CmdQuit implements GenericCommande
{	
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdQuit(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}

	public void execute(List<String> parametre) 
	{
		//receiver.get		
	}
}
