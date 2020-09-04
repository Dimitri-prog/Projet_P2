package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 * la class AnalyticCounter utilise trois méthodes qui retourne les méthodes de la
 * class readSymptomDataFromFile
 */
public class AnalyticsCounter {

	ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();

	/** lis le fichier passé en paramètre */
	public List<String> reading(String fileName) {
		return readSymptomDataFromFile.getSymptoms(fileName);
	}

	/**
	 * compte le nombre d'occurrences dans la liste des symptômes passé en paramètre
	 */

	public Map<String, Integer> count(List<String> symptoms) {
		return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
	}

	/**
	 * copie le fichier passé en paramètre dans le répertoire personnel de
	 * l’utilisateur
	 */
	public void save(Map<String, Integer> mapSymptomsOccurences) throws Exception {
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}
