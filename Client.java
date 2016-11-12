package lap6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Client {

	
	private static long wordsFound = 0;
	private static long wordsNotFound = 0;
	private static long compsFound = 0;
	private static long compsNotFound = 0;

	public static void main(String[] args) {

		File f = new File("random_dictionary.txt");

		MyLinkedList[] list = new MyLinkedList[26];
		for (int i = 0; i < list.length; i++) {
			list[i] = new MyLinkedList<String>();
		}

		try {
			int i = 0;
			Scanner in = new Scanner(f);
			while (in.hasNext()) {
				String a = in.next().toLowerCase();

				list[a.charAt(0) - 97].add(a);

			}
			in.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}

		String b = "";
		try {
			int[] count = new int[1];

			File g = new File("oliver.txt");
			Scanner in = new Scanner(g);
			while (in.hasNextLine()) {
				Scanner s2 = new Scanner(in.nextLine());
				while (s2.hasNext()) {

					b = s2.next().toLowerCase().replaceAll("[^a-zA-Z]+", " ").trim();
					if (b != null && !b.isEmpty()) {
						if (list[b.charAt(0) - 97].contains(b, count)) {

							wordsFound++;

							compsFound += count[0];
						} else {
							wordsNotFound++;
							compsNotFound += count[0];
						}
					}
				}
				s2.close();
			}

			in.close();
		} catch (IOException e) {
			System.out.println("File not found");
		} catch (Exception e) {
			System.out.print(e.getMessage());

		}

		double avgcompswordsfound = compsFound / wordsFound; 
																
		double avgcompswordsnotfound = compsNotFound / wordsNotFound; 
																		

		System.out.println("Words Found: " + wordsFound);
		System.out.println("Words Not Found: " + wordsNotFound);
		System.out.println("Average Comparisons Found: " + avgcompswordsfound);
		System.out.println("Average Comparisons Not Found: " + avgcompswordsnotfound);
	}

}
