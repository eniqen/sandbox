package com.github.eniqen.algo.hakerrank.hashtable;

import java.io.File;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RansomNote {
	public static void main(String[] args) {
		final String[] magazine = null;
		final String[] note = null;

		checkMagazine(magazine, note);
	}

	static String[] readFromFile(File file) {
		try(Scanner scanner = new Scanner(file)) {
			return scanner.nextLine().split(",");
		} catch (Exception e) {
			return new String[0];
		}
	}

	private static void checkMagazine(String[] magazine, String[] note) {
		boolean yesOrNo = true;

		final Map<String, Integer> magazineDict = grouped(magazine);
		final Map<String, Integer> notesDict    = grouped(note);

		for(Map.Entry<String, Integer> entry: notesDict.entrySet()) {
			final Integer mResult = magazineDict.get(entry.getKey());
			if (mResult == null || mResult < entry.getValue()) {
				System.out.println("ENTRY = " + entry + " MAGAZINE " + mResult);
				yesOrNo = false;
				break;
			}
		}
		System.out.println(yesOrNo ? "Yes": "No");
	}

	private static Map<String, Integer> grouped(String[] data) {
		final Map<String, Integer> dictionary = new HashMap<>();
		for (String datum : data) {
			dictionary.compute(
					datum,
					(s, counter) -> counter == null ? 1 : counter + 1
			);
		}
		return dictionary;
	}
}
