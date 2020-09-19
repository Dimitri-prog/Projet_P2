package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/** interface impl�ment�e par la class ReadSymptomDataFromFile */

public interface ISymptomReader {

	/**
	 * Cette m�thode lit un fichier pass� en param�tre et elle retourne une liste de sympt�mes.
	 * @param fileName nom du fichier passer en param�tre.
	 * @return Une liste des sympt�mes dans l�ordre alphab�tique.
	 */
	
	List<String> getSymptoms(String fileName);

	/**
	 * cette m�thode parcour la liste passer en param�tre et elle retourne le nombre d'occurence de chaque sympt�mes de la liste
	 * @param symptoms nom de la liste passer en param�tre.
	 * @return Une carte avec le nombre d'occurences de chaque sympt�mes.
	 */
	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

	/**
	 * cette m�thode copie la carte passer en param�tre dans le r�pertoire personelle de l'utilisateur de l'application.
	 * @param mapSymptomsOccurences nom de la carte passer en param�tre.
	 * @throws IOException
	 */
	void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException;

}
