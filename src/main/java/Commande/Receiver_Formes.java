 package Commande;


import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DAO.DaoFActory;
import DAO.DaoFigureGeometrique;
import DessinException.NomDeFigureInValide;
import DessinException.NullPointerObj;
import Formes.Carre;
import Formes.Cercle;
import Formes.CompositeFigure;
import Formes.FormeGeometrique;
import Formes.Point;
import Formes.Rectangle;
import Formes.Triangle;
import fr.uvsq.solid.pglp_9.Flash;

public class Receiver_Formes 
{
	private static final String SQL_SERIALIZE_OBJECT = null;
	 
	public void createCercle(List<String> parametre)
	{
		/**
		 * je parse les element de ma liste en int
		 * c1=cercle((1,1),2)
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
		//System.out.println(" entrer dans get cercle");
		DaoFActory.getCerlcleDAO().create(cercle);
		
	}
	/**
	 * methode qui affiche la description d'une figure stocké dans la BD
	 * @param variable: le nom de la figure
	 * @return : la description du nom de la figure
	 */
	public String readForme(String variable)
	{
		//System.out.println(" readForme:"+variable );
		return DaoFigureGeometrique.read(variable).toString();
		 
	}
	
	public void createRectangle(List<String> parametre)
	{
	
		/**
		 * je parse les elements de ma liste en int
		 * r1=rectangle((1,1),(3,5))
		 */
		
		int dxUpLeft=Integer.parseInt(parametre.get(2));
		int dyUpLeft=Integer.parseInt(parametre.get(3));
		int dxUpRight=Integer.parseInt(parametre.get(4));
		int dyUpRight=Integer.parseInt(parametre.get(5));
		String variable=parametre.get(0);
		
		
		/**
		 * je cree un objet cercle a l'aide des elements de ma liste
		 */
		Point UpLeft=new Point(dxUpLeft,dyUpLeft) ;
		Point UpRight=new Point(dxUpRight,dyUpRight) ;
		/**
		 * je cree un objet rectangle que je vais ensuite mettre dans la BD
		 */
		Rectangle rectangle=new Rectangle(variable,UpLeft,UpRight);
		DaoFActory.getRectangleDAO().create(rectangle);
	}

	public void createTriangle(List<String> parametre)
	{
	
		/**
		 * je parse les elements de ma liste en int
		 * t1=Triangle((4,4),(4,1),(5,2))
		 */
		
		int dxP1=Integer.parseInt(parametre.get(2));
		int dyP1=Integer.parseInt(parametre.get(3));
		int dxP2=Integer.parseInt(parametre.get(4));
		int dyP2=Integer.parseInt(parametre.get(5));
		int dxP3=Integer.parseInt(parametre.get(6));
		int dyP3=Integer.parseInt(parametre.get(7));
		String variable=parametre.get(0);
		
		
		/**
		 * je cree un objet triangle a l'aide des elements de ma liste
		 */
		Point p1=new Point(dxP1,dyP1) ;
		Point p2=new Point(dxP2,dyP2) ;
		Point p3=new Point(dxP3,dyP3) ;
		/**
		 * je cree un objet rectangle que je vais ensuite mettre dans la BD
		 */
		Triangle triangle=new Triangle(variable,p1,p2,p3);
		DaoFActory.getTriangleDAO().create(triangle);
	}
	public void createCarre(List<String> parametre)
	{
	

		/**
		 * je parse les elements de ma liste en int
		 * car1=carre((1,1),(3,5))
		 */
		
		int dxUpLeft=Integer.parseInt(parametre.get(2));
		int dyUpLeft=Integer.parseInt(parametre.get(3));
		int cote=Integer.parseInt(parametre.get(4));
		String variable=parametre.get(0);
		
		
		/**
		 * je cree un objet cercle a l'aide des elements de ma liste
		 */
		Point UpLeft=new Point(dxUpLeft,dyUpLeft) ;
		
		/**
		 * je cree un objet rectangle que je vais ensuite mettre dans la BD
		 */
		Carre carre=new Carre(variable,UpLeft,cote);
		DaoFActory.getCarreDAO().create(carre);
	}
	/**
	 * pour faire le move d'une figuree
	 * @param parametre
	 * @return
	 */
	public Object makeMove(List<String> parametre)
	{
		String variable=parametre.get(1);
		return DaoFigureGeometrique.read(variable);
	}
	/*
	 * pour quitter le programme
	 */
	public void getQuit()
	{
		System.exit(0);
	}
	/*
	 * pour faire le compose de plusieurs figure
	 */
	
	public void makeCompose(List<String> parametre) throws NullPointerObj
	{
		String nomComposite=parametre.get(0);
		CompositeFigure composite=new CompositeFigure(nomComposite);
		FormeGeometrique forme;
		int i=0;
		
		for(String saisie : parametre)
		{
			if(i>=2)
			{
				System.out.println("ajout de "+saisie);
				forme=	((FormeGeometrique)DaoFigureGeometrique.read(saisie));
				composite.add(forme);
			}
			i++;
		}
		//Flash.affiche(composite.toString());
		if(composite!=null)
		DaoFActory.getCompositePerso().create(composite);
		throw new NullPointerObj();
		
	}
	
	/**
	 * methode d'aide
	 */
	
	public static void help(String chaineUser)
	{
		if(chaineUser.toLowerCase().equals("help"))
		{ Flash.affiche("==============>:\n"
                + "Creation : \n"
                + "c1 = Cercle((centrX, centreY), rayon)\n"
                + "c2 = Carre((xUpleft, yUpleft),(xUpright, yUpright))\n"
                + "r1 = Rectangle((xUpleft, yUpleft),(xUpright, yUpright))\n"
                + "t1 = Triangle((x, y), (x, y), (x, y))\n"
                + "g1 = Compose(c1, c2, r1, t1)\n"
                + "Déplacement : move(c1(x, y))\n"
                + "Affichage : show(r1)\n"
                + "Quitter : quit\n\n"+
               "==============>:\n"
                );
		}
		
	}
	
	
}
