package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Cette classe fournie des services permettant de manipuler un fichier de symptômes. 
 * @author Pano
 *
 */


public class AnalyticsCounter {

	ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();

	
	/**
	 * Cette méthode lit un fichier passé en paramètre et elle retourne une liste de symptômes.
	 * 
	 * @param fileName nom du fichier passer en paramètre.
	 * @return Une liste des symptômes dans l’ordre alphabétique.
	 */
	public List<String> reading(String fileName) {
		return readSymptomDataFromFile.getSymptoms(fileName);
	}

	
	/**
	 * cette méthode parcour la liste passer en paramètre et elle retourne le nombre d'occurence de chaque symptômes de la liste
	 * @param symptoms nom de la liste passer en paramètre.
	 * @return Une carte avec le nombre d'occurences de chaque symptômes
	 */
	public Map<String, Integer> count(List<String> symptoms) {
		return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
	}

	
	/**
	 * cette méthode copie la carte passer en paramètre dans le répertoire personelle de l'utilisateur de l'application.
	 * @param mapSymptomsOccurences nom de la carte passer en paramètre.
	 * @throws Exception
	 */
	public void save(Map<String, Integer> mapSymptomsOccurences) throws Exception {
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}
