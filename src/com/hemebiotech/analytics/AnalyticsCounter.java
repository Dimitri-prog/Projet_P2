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
     * Cette méthode parcour la liste passée en paramètre et elle retourne le nombre d'occurrence de chaque symptôme de la liste.
     *
     * @param symptoms nom de la liste passer en paramètre.
     * @return Une carte avec le nombre d'occurences de chaque symptômes
     */
    public Map<String, Integer> count(List<String> symptoms) {
        return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
    }


    /**
     * Cette méthode crée le fichier de sortie dans le répertoire personel de l'utilisateur à partir de la map passée en paramètre.
     *
     * @param mapSymptomsOccurences Map contenant pour chaque maladie le nombre d'occurrence qui lui est associé.
     * @throws Exception exception levée en cas d'évènements imprévus
     */
    public void save(Map<String, Integer> mapSymptomsOccurences) throws Exception {
        readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
    }
}
