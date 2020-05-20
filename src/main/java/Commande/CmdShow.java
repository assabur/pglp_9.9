package Commande;

import java.util.List;

import DessinException.NomDeFigureInValide;

public class CmdShow implements GenericCommande
 {
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdShow(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	public void execute(List<String> parametre) 
	{	
		System.out.println("dans execute show");
			receiver.readForme(parametre);		
	}
}
