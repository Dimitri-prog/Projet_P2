package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadSymptomDataFromFile implements ISymptomReader {

	@Override
	public List<String> getSymptoms(String symptoms) {
		// liste qui va recevoir les sympt�mes lus
		List<String> result = new ArrayList<String>();

		if (symptoms != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(symptoms));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				// classement des sympt�mes par ordre alphab�tique
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
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		// parcours la liste des sympt�mes passer en param�tre de la m�thode
		for (String symptom : symptoms) {
			if (map.containsKey(symptom) == false) {
				// copie la liste dans la carte
				map.put(symptom, Collections.frequency(symptoms, symptom));
			}
		}

		return map;
	}

	@Override
	public void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException {
		// R�cup�re le r�pertoire personnel de l�utilisateur.
		String currentUsersHomeDir = System.getProperty("user.home");
		String path = currentUsersHomeDir + System.getProperty("file.separator") + "result.out";
		// objet permettant de copier le fichier dans le r�pertoire personnel
		// de l'utilisateur
		FileWriter writer = new FileWriter(path);
		if (mapSymptomsOccurences != null && !mapSymptomsOccurences.isEmpty()) {
			mapSymptomsOccurences.forEach((key, value) -> {
				try {
					// copie le fichier dans le r�pertoire personnel de l'utilisateur
					writer.write(key + "=" + value);
					writer.write(System.getProperty("line.separator"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} else {
			writer.write("aucun sympt�me n'a �t� trouv�");
		}
		writer.close();
		System.out.println("le fichier de sortie se trouve: " + path);
	}
}
