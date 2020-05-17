package Commande;

import java.util.List;

public interface Commande {
	/*
	 * execute une commande en prenant ces parametres en entre
	 */
	public void execute(List<String> parametre);
}
