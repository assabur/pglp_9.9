 package Commande;


import java.util.List;

import DAO.DaoFActory;
import Formes.Cercle;
import Formes.Point;

public class Receiver_Formes 
{
	private static final String SQL_SERIALIZE_OBJECT = null;
	 
	public void getCercle(List<String> parametre)
	//c1=cercle((1,1),2)
	{
		/*System.out.println(parametre.get(0)+"="+"cercle "+
	"(("+parametre.get(2)+","+parametre.get(3)+")"+","+parametre.get(4)+")");*/
		
		/*
		 * je parse les element de ma liste en int
		 */
		int radius=Integer.parseInt(parametre.get(4));
		int dx=Integer.parseInt(parametre.get(2));
		int dy=Integer.parseInt(parametre.get(3));
		String variable=parametre.get(0);
		
		/*
		 * je cree un objet cercle a l'aide des elements de ma liste
		 */
		Point center=new Point(dx,dy) ;
		Cercle cercle=new Cercle(variable, center, radius);
		System.out.println(" entrer dans get cercle");
		DaoFActory.getCerlcleDAO().create(cercle);
		
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
