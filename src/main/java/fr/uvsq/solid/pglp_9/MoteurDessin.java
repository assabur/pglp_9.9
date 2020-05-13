package fr.uvsq.solid.pglp_9;

public class MoteurDessin {
	private Interpreter interpreteur=new Interpreter();
	
	
	  public void init()  
		{			
			this.interpreteur.addCommand("cercle",this.interpreteur.parametre);
				 	
		}

}
