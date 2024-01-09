package gr.atc.training.dictionaryFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dictionary {
	ArrayList<String> dictionary_words = new ArrayList<String>();
	
	public Dictionary(String dict_path) {
		dictionary_words = readFileToList(dict_path);
	}

	private ArrayList<String> readFileToList(String path) {
		ArrayList<String> words = new ArrayList<String>();
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
		return words;
	}

	public int getWordCount(String prefix, String suffix, int letterCount) {
		// Count how many words in words arraylist are valid
		int count = 0;
		for (String w : dictionary_words) {
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

	public void getSpellingCheck(String text_path) {
		// Read words from text file
		//ArrayList<String> text_words = new ArrayList<String>();
		String line = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(text_path)), "UTF-8"));
			line = reader.readLine();
			System.out.println("Words in text not contained in dictionary:");
			while (line != null) {
				String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
				//text_words.addAll(Arrays.asList(words));
				for (String w : words) {
					if (!w.equals("") && !dictionary_words.contains(w)) {
						System.out.print(w + " ");
					}
				}
				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	public void printrandomwords(int N) {
		Random rand = new Random();
		System.out.println("Printing " + N + " random words from the dictionary:");
		for (int i=0; i<N; i++) {
			int random_word_idx = rand.nextInt(dictionary_words.size()-1);
			System.out.print(dictionary_words.get(random_word_idx) + " ");
		}
		System.out.println();
	}

}
