package Formes;

import java.util.ArrayList;
public class AfficheComposite {
	
	/*
	 * declaration des attributs
	 */
	private ArrayList<FormeGeometrique>tab=new ArrayList<FormeGeometrique>();
	/*
	 * methode qui prend en entré la racine de notre graphe d'hierarchie
	 */
	public AfficheComposite (FormeGeometrique root)
	{
		this.tab.add(root);
	}
	
	/*
	 * methode qui retourne un nouveau iterateur
	 */
	public Iterator getIterator ()
	{
		return new GroupeIterator();
		
	}
	private class GroupeIterator implements Iterator
	{
		/*
		 * parcourir l'architecture en verifiant a chaque fois que l'instance est un composite ou pas
		 */
		public  GroupeIterator ()
		{
			int index =0;
			while (index < tab.size())
			{	
				if	(tab.get(index) instanceof FormeGeometrique)
				{	
					 for (FormeGeometrique figure : ((CompositeFigure)tab.get(index)).formes )
					{ 		      
				          tab.add(figure);		
				    }				
				}				
				index ++;
			}
		}
		int i=0;

		 /*
		 * methode qui verifie si il existe un suivant dans la hierarchie
		 */
		public boolean hasNext() {
			if (i < tab.size())			
			 return true;			
			 return false;
		}

		/*
		 * methode qui renvoie la prochaine figure de la hierarchie
		 */
		public FormeGeometrique Next() {
			
			if (this.hasNext()){
				i++;
			return tab.get(i-1);
			}
			return null;
		}		
	}


}
