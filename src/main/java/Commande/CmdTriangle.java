package Commande;

import java.util.List;

public class CmdTriangle implements SpecificCommand
{
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdTriangle(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List<String> parametre)
	{
			receiver.createTriangle(parametre); 
	}
}
