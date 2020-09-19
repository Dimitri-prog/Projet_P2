package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/** interface implémentée par la class ReadSymptomDataFromFile */

public interface ISymptomReader {

	/**
	 * Cette méthode lit un fichier passé en paramètre et elle retourne une liste de symptômes.
	 * @param fileName nom du fichier passer en paramètre.
	 * @return Une liste des symptômes dans l’ordre alphabétique.
	 */
	
	List<String> getSymptoms(String fileName);

	/**
	 * cette méthode parcour la liste passer en paramètre et elle retourne le nombre d'occurence de chaque symptômes de la liste
	 * @param symptoms nom de la liste passer en paramètre.
	 * @return Une carte avec le nombre d'occurences de chaque symptômes.
	 */
	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

	/**
	 * cette méthode copie la carte passer en paramètre dans le répertoire personelle de l'utilisateur de l'application.
	 * @param mapSymptomsOccurences nom de la carte passer en paramètre.
	 * @throws IOException
	 */
	void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException;

}
