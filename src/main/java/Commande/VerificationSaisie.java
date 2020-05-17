package Commande;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DessinException.ErreurCommandeException;

/*
 * classe qui permet de verifier si la saisie de l'user correspond au pattern des differentres commandes
 */
public class VerificationSaisie
{
	/**
	 * format generale pour la creation de figure nom = commande
	 */
	private static final String regex = ".+=.+";
	private static final Pattern pattern = Pattern.compile(regex);

	/**
	 * format generale cercle nom = commande((nombre,nombre),nombre)
	 */
	private static final String regexcercle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*\\.?\\d+?\\s*"
			+ ",\\s*\\d*\\.?\\d+\\s*\\)\\s*,\\s*\\d*\\.?\\d+?\\s*\\)";
	private static final Pattern patterncercle = Pattern.compile(regexcercle);

	/**
	 * format generale rectangle et carre nom = commande((nombre,nombre),(nombre,nombre))
	 */
	private static final String regexrectcarre = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*"
			+ ",\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\."
			+ "?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternrectcarre = Pattern.compile(regexrectcarre);

	/**
	 * format generale triangle nom = commande((nombre,nombre),(nombre,nombre),(nombre,nombre))
	 */
	private static final String regextriangle = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*\\(\\s*\\d*.?\\d+?\\s*,"
			+ "\\s*\\d*.?\\d+\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\"
			+ "d+?\\s*\\)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*\\,\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patterntriangle = Pattern.compile(regextriangle);

	/**
	 * forme general pour deplacer une figure
	 */
	private static final String regexmove = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-]+)\\s*,\\s*\\(\\s*\\d*?\\.?\\d+?\\s*,"
			+ "\\s*\\d*?\\.?\\d+?\\s*\\)\\s*\\)";
	private static final Pattern patternmove = Pattern.compile(regexmove);

	private static final String regexaffiche = "^([a-zA-Z]+)\\s*\\(\\s*([a-zA-Z0-9_-])+\\s*\\)";
	private static final Pattern patternaffiche = Pattern.compile(regexaffiche);

	private static final String regexgroup = "^([a-zA-Z0-9_-]+)\\s*=\\s*([a-zA-Z]+)\\s*\\(\\s*(([a-zA-Z0-9_-]*\\s*+),*)+\\)";
	private static final Pattern patterngroup = Pattern.compile(regexgroup);
	private String text="";
	private static int TYPE;
	/**
	 * Verifie le format du text entrer par l'user
	 * @param text format enter par l'user
	 * @return true or false
	 * @throws ErreurCommandeException 
	 */
	public static boolean verificationSaisieUser(String text)  {
		Matcher matcher = pattern.matcher(text);
		//verifie si cest une creation
		if(matcher.matches()) {
			TYPE = 1;
			matcher = patterncercle.matcher(text);
			if(matcher.matches())
				return true;
			else {
				matcher = patternrectcarre.matcher(text);
				if(matcher.matches())
					return true;
				else {
					matcher = patterntriangle.matcher(text);
					if(matcher.matches())
						return true;
					else {
						matcher = patterngroup.matcher(text);
						if(matcher.matches())
							return true;
					}
				}
			}

		}else {
			TYPE = 0;
			matcher = patternmove.matcher(text);
			if(matcher.matches()){
				return true;
			}else {
				matcher = patternaffiche.matcher(text);
				if(matcher.matches())
					return true;
			}
		}
		return false;
	}
	/**
	 * retourne le type de la commande saisie par l'utilisateur
	 * @return TYPE
	 */
	public static int gettypeString() {
		return TYPE;
	}
}
