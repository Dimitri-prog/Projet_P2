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
     * Cette m�thode parcour la liste pass�e en param�tre et elle retourne le nombre d'occurrence de chaque sympt�me de la liste.
     *
     * @param symptoms nom de la liste passer en param�tre.
     * @return Une carte avec le nombre d'occurences de chaque sympt�mes
     */
    public Map<String, Integer> count(List<String> symptoms) {
        return readSymptomDataFromFile.getSymptomsWithOccurences(symptoms);
    }


    /**
     * Cette m�thode cr�e le fichier de sortie dans le r�pertoire personel de l'utilisateur � partir de la map pass�e en param�tre.
     *
     * @param mapSymptomsOccurences Map contenant pour chaque maladie le nombre d'occurrence qui lui est associ�.
     * @throws Exception exception lev�e en cas d'�v�nements impr�vus
     */
    public void save(Map<String, Integer> mapSymptomsOccurences) throws Exception {
        readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
    }
}
