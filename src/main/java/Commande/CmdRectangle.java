package Commande;

import java.util.List;

public class CmdRectangle implements SpecificCommand{


	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdRectangle(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List<String> parametre)
	{
			receiver.getRectangle(parametre);
	}

}
