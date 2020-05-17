package Commande;

import java.util.List;

public class CmdCarre implements SpecificCommand
{
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdCarre(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List<String> parametre)
	{
			receiver.getCarre(parametre);
	}
}
