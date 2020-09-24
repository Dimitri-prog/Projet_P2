package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Contrat d'interface des services pour traiter un fichier de symptômes
 */
interface ISymptomReader {

    /**
     * Cette méthode lit un fichier passé en paramètre et elle retourne une liste de symptômes.
     *
     * @param fileName nom du fichier passer en paramètre.
     * @return Une liste des symptômes dans l’ordre alphabétique.
     */
    List<String> getSymptoms(String fileName);

    /**
     * Cette méthode parcourt la liste passée en paramètre et elle retourne le nombre d'occurence de chaque symptômes.
     *
     * @param symptoms nom de la liste passer en paramètre.
     * @return Une carte avec le nombre d'occurences de chaque symptômes.
     */
    Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

    /**
     * Cette méthode copie la map dans le répertoire personelle de l'utilisateur de l'application.
     *
     * @param mapSymptomsOccurences map contenant pour chaque symptôme son nombre d'occurrence.
     * @throws IOException
     */
    void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException;

}