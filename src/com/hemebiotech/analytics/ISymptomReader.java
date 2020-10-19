package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Contrat d'interface des services pour traiter un fichier de symptômes
 */
interface ISymptomReader {

	/**
	 * Cette méthode lit un fichier passé en paramètre et elle retourne une liste de
	 * symptômes.
	 *
	 * @param fileName nom du fichier passer en paramètre.
	 * @return Une liste des symptômes dans l’ordre alphabétique.
	 */
	List<String> getSymptoms(String fileName);

	/**
	 * Cette méthode parcourt la liste passée en paramètre et elle retourne le
	 * nombre d'occurence de chaque symptômes.
	 *
	 * @param symptoms nom de la liste passer en paramètre.
	 * @return Une carte avec le nombre d'occurences de chaque symptômes.
	 */
	Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

}