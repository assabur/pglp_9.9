 package Commande;


import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import DAO.DaoFActory;
import DAO.DaoFigureGeometrique;
import DessinException.NomDeFigureInValide;
import Formes.Cercle;
import Formes.FormeGeometrique;
import Formes.Point;
import fr.uvsq.solid.pglp_9.Flash;

public class Receiver_Formes 
{
	private static final String SQL_SERIALIZE_OBJECT = null;
	 
	public void createCercle(List<String> parametre)
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
		//System.out.println("radius "+radius+" dx "+dx+" dy "+dy+" variable"+variable);
		
		/*
		 * je cree un objet cercle a l'aide des elements de ma liste
		 */
		Point center=new Point(dx,dy) ;
		Cercle cercle=new Cercle(variable, center, radius);
		//System.out.println(" entrer dans get cercle");
		DaoFActory.getCerlcleDAO().create(cercle);
		
	}
	
	public FormeGeometrique readForme(List <String> parametre)
	{	
		/*
		 * le nom de la figure saisie par l'user
		 */
		String nom=parametre.get(1);
		//String type=DaoFigureGeometrique.read(nom);
		HashMap<String, Object> elmt=new HashMap<>();
		elmt=DaoFigureGeometrique.read(nom);
		

		if(elmt.containsKey("cercle"))
		{
			return DaoFActory.getCerlcleDAO().read(elmt.get("cercle"));			
		}

		return null;
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
