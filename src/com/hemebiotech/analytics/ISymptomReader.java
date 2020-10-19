package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Contrat d'interface des services pour traiter un fichier de sympt�mes
 */
interface ISymptomReader {

	/**
	 * Cette m�thode lit un fichier pass� en param�tre et elle retourne une liste de
	 * sympt�mes.
	 *
	 * @param fileName nom du fichier passer en param�tre.
	 * @return Une liste des sympt�mes dans l�ordre alphab�tique.
	 */
	List<String> getSymptoms(String fileName);

	/**
	 * Cette m�thode parcourt la liste pass�e en param�tre et elle retourne le
	 * nombre d'occurence de chaque sympt�mes.
	 *
	 * @param symptoms nom de la liste passer en param�tre.
	 * @return Une carte avec le nombre d'occurences de chaque sympt�mes.
	 */
	Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

}