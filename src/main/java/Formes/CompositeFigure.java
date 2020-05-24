package Formes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeFigure extends FormeGeometrique implements Serializable
{
	/**
	 * methode qui effectue un move sur l'ensemble des elements d'un composite
	 */

	public void move(int dx, int dy)
	{
		for(FormeGeometrique forme :formes)
		{
			forme.move(dx, dy);
		}
	}
	private String name;
	public String getName()
	{
		return this.name;
	}
	public CompositeFigure(String name)
	{
		this.name=name;
	}
	public ArrayList<FormeGeometrique> formes=new ArrayList<FormeGeometrique>();
		 
	 /*
	  *methode qui ajoute une formes dans l'hierarchie
	 */	 
	public void add (FormeGeometrique mafigure)
	{
		formes.add(mafigure);
	}
	
	/**
	 * retoure une liste immuable du groupe de figure
	 * @return
	 */
	public List<FormeGeometrique> gettab(){
		return Collections.unmodifiableList(formes);
	}
	/*
	 * methode qui supprime une figure de l'hierarchie
	 */
	public void remove(FormeGeometrique mafigure)
	{
		formes.remove(mafigure);
	}
	/**
	 * redefinisions la methode tostring
	 */
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(" (Groupe=>");
		for(FormeGeometrique formesComposite: formes)
		{			
			str.append(formesComposite.toString()+" ");
		}	
		str.append(" )");
		return str.toString();		
	}
}
