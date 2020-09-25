package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Classe de démarrage du projet
 */
public class MainProject {

    public static void main(String[] args) throws Exception {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        List<String> symptoms = analyticsCounter.reading("symptoms.txt");
        Map<String, Integer> mapSymptomsOccurences = analyticsCounter.count(symptoms);
        analyticsCounter.save(mapSymptomsOccurences);
    }

}