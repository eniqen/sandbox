package com.github.eniqen.algo.hakerrank.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class FraudulentActivity {
	public static void main(String[] args) throws FileNotFoundException {
		int[] expenditure = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
		int[] expenditure2 = new int[]{1, 2, 3, 4, 4};
		int[] expenditure3 = new int[]{10, 20, 30, 40, 50};
		String path = "/Users/eniqen/IdeaProjects/sandbox/algo/src/main/java/com/github/eniqen/algo/hakerrank/sort/data.txt";
		int[] arr = fromFile(path);


		System.out.println(arr.length);
//		System.out.println(notificationCount(expenditure, 5));
		System.out.println(notCount(arr, 40001));
}


	private static int[] fromFile(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		int [] result = new int[200_000];

		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(" ");
			for (int i = 0; i < data.length; i++) {
				result[i] = Integer.parseInt(data[i]);
			}
		}

		return result;
	}

	private static int notificationCount(int[] expenditure, int d) {
		int count = 0;
		int start = 0;
		while(start + d < expenditure.length) {
			double median = getMedian(expenditure, start, d);
			int current = expenditure[start + d];
			if(current >= median * 2) count++;
			start++;
		}
		return count;
	}

	private static double getMedian(int[] expenditure, int from, int d) {
		int[] copy = Arrays.copyOfRange(expenditure, from, from + d);
		Arrays.sort(copy);
		int index = (from + d - 1) / 2;
		return d % 2 == 0
			   ? (double) (copy[index] + copy[index + 1]) / 2
			   : copy[index];
	}

	private static int notCount(int[] expenditure, int d) {
		int count = 0;
		int start = 0;

		final Map<Integer, Integer> freq = new TreeMap<>();

		while(start < d) {
			freq.merge(expenditure[start], 1, Integer::sum);
			start++;
		}

		while(start < expenditure.length) {
			int current = expenditure[start];
			int toDelete = expenditure[start - d];
			double mediana = getMed(freq, d);

			if(current >= mediana * 2) count++;

			Integer ifExist = freq.get(toDelete);
			if(ifExist != null && ifExist > 1) {
				freq.put(toDelete, freq.get(toDelete) - 1);
			} else freq.remove(toDelete);
			
			freq.merge(current, 1, Integer::sum);
			start++;
		}

		return count;
	}

	private static double getMed(Map<Integer, Integer> freq, int d) {
		int index = d / 2;
		int [] arr = new int[d];
		int counter = 0;

		Iterator<Map.Entry<Integer, Integer>> iterator = freq.entrySet().iterator();

		while(iterator.hasNext() && counter < index + 1) {
			Map.Entry<Integer, Integer> current = iterator.next();
			for (int i = counter; i < counter + current.getValue(); i++) {
				arr[i] = current.getKey();
			}
			counter += current.getValue();
		}

		return d % 2 == 0
			   ? (double) (arr[index - 1] + arr[index]) / 2
			   : arr[index];
	}
}
