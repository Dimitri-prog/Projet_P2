package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadSymptomDataFromFile implements ISymptomReader {
	@Override
	public List<String> getSymptoms(String symptoms) {
		List<String> result = new ArrayList<>();
		if (symptoms != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(symptoms));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				// Ordonner les symptômes par ordre alphabétique
				Collections.sort(result);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms) {
		Map<String, Integer> map = new LinkedHashMap<>();
		// parcours la liste des symptômes passés en paramètre de la méthode
		for (String symptom : symptoms) {
			// copie la liste dans la map
			map.put(symptom, Collections.frequency(symptoms, symptom));
		}
		return map;
	}

}
