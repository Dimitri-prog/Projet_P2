package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Cette classe fournie des services permettant de manipuler un fichier de sympt�mes. 
 * @author Pano
 *
 */


public class AnalyticsCounter {

	ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();

	
	/**
	 * Cette m�thode lit un fichier pass� en param�tre et elle retourne une liste de sympt�mes.
	 * 
	 * @param fileName nom du fichier passer en param�tre.
	 * @return Une liste des sympt�mes dans l�ordre alphab�tique.
	 */
	public List<String> reading(String fileName) {
		return readSymptomDataFromFile.getSymptoms(fileName);
	}

	
	/**
	 * cette m�thode parcour la liste passer en param�tre et elle retourne le nombre d'occurence de chaque sympt�mes de la liste
	 * @param symptoms nom de la liste passer en param�tre.
	 * @return Une carte avec le nombre d'occurences de chaque sympt�mes
	 */
	public Map<String, Integer> count(List<String> symptoms) {
		return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
	}

	
	/**
	 * cette m�thode copie la carte passer en param�tre dans le r�pertoire personelle de l'utilisateur de l'application.
	 * @param mapSymptomsOccurences nom de la carte passer en param�tre.
	 * @throws Exception
	 */
	public void save(Map<String, Integer> mapSymptomsOccurences) throws Exception {
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}
