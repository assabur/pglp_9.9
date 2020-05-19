package Formes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeFigure extends FormeGeometrique
{

	public void move(int dx, int dy)
	{
	}
	private String name;
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
	
}
