package fr.uvsq.solid.pglp_9;

import java.time.LocalDateTime;

/*
 * affiche une donnée en respectant le 
 */
	public class Flash {

		public static void affiche(String text)
		{
			System.out.println(LocalDateTime.now()+": "+text);
		}
}
