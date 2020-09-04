package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 * la class AnalyticCounter utilise trois m�thodes qui retourne les m�thodes de la
 * class readSymptomDataFromFile
 */
public class AnalyticsCounter {

	ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();

	/** lis le fichier pass� en param�tre */
	public List<String> reading(String fileName) {
		return readSymptomDataFromFile.getSymptoms(fileName);
	}

	/**
	 * compte le nombre d'occurrences dans la liste des sympt�mes pass� en param�tre
	 */

	public Map<String, Integer> count(List<String> symptoms) {
		return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
	}

	/**
	 * copie le fichier pass� en param�tre dans le r�pertoire personnel de
	 * l�utilisateur
	 */
	public void save(Map<String, Integer> mapSymptomsOccurences) throws Exception {
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}
