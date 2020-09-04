package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/** interface impl�ment�e par la class ReadSymptomDataFromFile */
public interface ISymptomReader {
	List<String> getSymptoms(String fileName);

	public Map<String, Integer> getSymptomsWithOccurences(List<String> symptoms);

	void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException;

}
