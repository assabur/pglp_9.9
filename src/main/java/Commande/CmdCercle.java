package Commande;

import java.util.List;

public class CmdCercle implements SpecificCommand{
	
	
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdCercle(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List <String> parametre)
	{
			receiver.createCercle(parametre);
	}
}
