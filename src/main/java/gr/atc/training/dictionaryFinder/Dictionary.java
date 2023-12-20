package gr.atc.training.dictionaryFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dictionary {
	ArrayList<String> words = new ArrayList<String>();
	
	private void readFileToList(String path) {
		String word = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));
			word = reader.readLine();
			while (word != null) {
				words.add(word);
				word = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getWordCount(String prefix, String suffix, int letterCount) {
		
		// Get words from file
		readFileToList("english3.txt");
		
		// Count how many words in words arraylist are valid
		int count = 0;
		for (String w:words) {
			if (prefix != null && w.startsWith(prefix) == false) {
				continue;
			}
			if (suffix != null && w.endsWith(suffix) == false) {
				continue;
			}
			if (letterCount > 0 && w.length() != letterCount) {
				continue;
			}
			// Word is valid
			count++;
		}
		return count;
	}

}
