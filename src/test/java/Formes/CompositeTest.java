package Formes;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.solid.pglp_9.Flash;

public class CompositeTest {

	private static Point p1;
	private static Point p2;
	private static Point p3;
	private static Triangle triangle;
	private static Rectangle rectangle;
	private static Cercle cercle;
	private static CompositeFigure composite;
	private static AfficheComposite affiche;

	@Before public void setup()
	{
		p1= new Point(1,2);
		p2= new Point(4,2);
		p3= new Point(1,5);
		triangle=new Triangle("Montriangle ",p1,p2,p3);	
		rectangle=new Rectangle("monRectangle", p1, p2);
		cercle=new Cercle("monCercle", p1, 4);
		composite=new CompositeFigure("monComposite");
		composite.add(triangle);
		composite.add(rectangle);
		composite.add(cercle);
		
		affiche=new AfficheComposite(composite);
	}
	@Test
	public void CompositeTest()
	{
		try
		{
			System.out.println(affiche.getIterator().Next().toString());

		while(affiche.getIterator().hasNext())
		{
			FormeGeometrique nextValue=affiche.getIterator().Next();
			Flash.affiche(nextValue.toString());
		}
		}
		catch(ClassCastException e)
		{
			e.getMessage();
		}
	}

}
