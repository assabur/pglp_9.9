package Commande;

import java.util.List;

public class Receiver_Formes 
{
	public void getCercle(List<String> parametre)
	//c1=cercle((1,1),2)
	{
		System.out.println(parametre.get(0)+"="+"cercle "+
	"(("+parametre.get(2)+","+parametre.get(3)+")"+","+parametre.get(4)+")");
		
	}
	public void getRectangle(List<String> parametre)
	{
	
		
	}

	public void getTriangle(List<String> parametre)
	{
	
	}
	public void getCarre(List<String> parametre)
	{
	
	}
	public void getMove(List<String> parametre)
	{
	
	}
	public void getQuit()
	{
		System.exit(-1);
	}
}
