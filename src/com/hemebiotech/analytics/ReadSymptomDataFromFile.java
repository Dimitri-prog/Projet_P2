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
	/** m�thode permettant la lecture des sympt�mes */
	public List<String> getSymptoms(String sympt�mes) {
		/** liste qui va recevoir les sympt�mes lus */
		List<String> resulta = new ArrayList<String>();

		if (sympt�mes != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(sympt�mes));
				String line = reader.readLine();
				while (line != null) {
					resulta.add(line);
					line = reader.readLine();
				}
				/** classement des sympt�mes par ordre alphab�tique */
				Collections.sort(resulta);

				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resulta;
	}

	/** m�thode qui retourne le nombre d'occurrences des sympt�mes */
	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		/** parcours la liste des sympt�mes passer en param�tre de la m�thode */
		for (String symptom : symptoms) {
			if (map.containsKey(symptom) == false) {
				/** copie la liste dans la carte */
				map.put(symptom, Collections.frequency(symptoms, symptom));
			}
		}

		return map;
	}

	/**
	 * m�thode qui copie les sympt�mes dans r�pertoire personnel de l'utilisateur
	 */
	public void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException {
		/** r�cup�re le r�pertoire personnel de l'utilisateur */
		String currentUsersHomeDir = System.getProperty("user.home");
		String path = currentUsersHomeDir + System.getProperty("file.separator") + "result.out";
		/**
		 * objet permettant de copier le fichier dans le r�pertoire personnel de
		 * l'utilisateur
		 */
		FileWriter writer = new FileWriter(path);
		if (mapSymptomsOccurences != null && !mapSymptomsOccurences.isEmpty()) {
			mapSymptomsOccurences.forEach((key, value) -> {
				try {
					/** copie le fichier dans le r�pertoire personnel de l'utilisateur */
					writer.write(key + "=" + value);
					writer.write(System.getProperty("line.separator"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} else {
			writer.write("aucun symptome n'a �t� trouv�");
		}
		writer.close();
		System.out.println("le fichier de sortie se trouve: " + path);
	}
}
