package Commande;

import java.util.List;

import DAO.DaoFigureGeometrique;
import DessinException.BdException;
import DessinException.iOdessinException;
import Formes.FormeGeometrique;
import fr.uvsq.solid.pglp_9.Flash;

public class CmdMove implements GenericCommande {
	
	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdMove(Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}
	/**
	 * move(c1,(1,5))
	 */
	public void execute(List<String> parametre)
	{
		int dx=Integer.parseInt(parametre.get(2));
		String name=parametre.get(1);
		int dy=Integer.parseInt(parametre.get(3));
		//System.out.println("test "+dx+" "+dy+" "+parametre.get(1));
		Object monObjet;
		try {
			monObjet = receiver.makeMove(parametre);
			//Flash.affiche(((FormeGeometrique)monObjet).toString());
			if(monObjet!=null)
			{
				FormeGeometrique newObjet=((FormeGeometrique)monObjet);
				newObjet.move(dx, dy);
				Flash.affiche(newObjet.toString());	
				DaoFigureGeometrique.update(newObjet,name);	
				
			}
			else
			Flash.affiche("Modification non prise en charge");
		} catch (BdException | iOdessinException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		

	}
}
