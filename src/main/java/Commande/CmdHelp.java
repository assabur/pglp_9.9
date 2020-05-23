package Commande;

import java.util.List;
/**@author MAIGA
 * classe commande Help qui affiche l'aide
 */
public class CmdHelp  implements GenericCommande {

	private Receiver_Formes receiver=new Receiver_Formes();
	public CmdHelp (Receiver_Formes receiver)
	{
		this.receiver=receiver;
	}

	@Override
	public void execute(List<String> parametre) {
		receiver.help(parametre.get(0));
	}
}
