package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataFromFile {

	/**
	 * Cette m�thode copie la map dans le r�pertoire personelle de l'utilisateur de
	 * l'application.
	 *
	 * @param mapSymptomsOccurences map contenant pour chaque sympt�me son nombre
	 *                              d'occurrence.
	 * @throws IOException
	 */
	public void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException {
		String currentUsersHomeDir = System.getProperty("user.home");
		String path = currentUsersHomeDir + System.getProperty("file.separator") + "result.out";
		FileWriter writer = new FileWriter(path);
		if (mapSymptomsOccurences != null && !mapSymptomsOccurences.isEmpty()) {
			mapSymptomsOccurences.forEach((key, value) -> {
				try {
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
