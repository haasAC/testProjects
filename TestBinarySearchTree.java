
import java.io.*;
import java.util.*;

/**
 * CS-12J Asn 3 Binarysearchtree Purpose: Uses binarysearchtree to spell check
 *
 * @author Haseeb Chaudhry
 * @version 1.0 11/11/2016
 */
public class TestBinarySearchTree {

    public static BinarySearchTree[] list;
    public static long wordsFound = 0;
    public static long wordsNotFound = 0;
    public static long compsWordsFound = 0;
    public static long compsWordsNotFound = 0;

    public static void main(String[] args) {

        /**
         * Reads in dictionary file
         *
         * Create a list with 26 binary trees
         */
        File f = new File("random_dictionary.txt");
        @SuppressWarnings("rawtypes")
        BinarySearchTree[] list = new BinarySearchTree[26];
        for (int i = 0; i < list.length; i++) {
            list[i] = new BinarySearchTree<String>();
        }

        try {
            int i = 0;
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String a = in.next().toLowerCase();

                list[(int) a.charAt(0) - 97].insert(a);

            }
            in.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }

        /**
         * Reads in the oliver file
         *
         * removes extra characters and spaces and finds comparisons for words
         */
        String b = "";
        try {

            File g = new File("oliver.txt");
            Scanner in = new Scanner(g);
            while (in.hasNextLine()) {
                Scanner s2 = new Scanner(in.nextLine());
                while (s2.hasNext()) {

                    b = s2.next().toLowerCase().replaceAll("[^a-zA-Z]+", "").trim();

                    if (b != null && !b.isEmpty()) {
                        int index = ((int) b.charAt(0)) - 97;
                        list[index].comparisons = 0;
                        if (list[(int) b.charAt(0) - 97].search(b)) {

                            compsWordsFound += list[index].comparisons;
                            wordsFound++;
                            // System.out.println("comps Found - " +
                            // compsWordsFound );
                            // System.out.println("words Found - " + wordsFound
                            // + " " + b);
                        } else {
                            compsWordsNotFound += list[index].comparisons;
                            wordsNotFound++;

                        }
                    }
                }
                s2.close();
            }

            in.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        /**
         * @returns the counters and average words found and not found
         * comparisons
         */
        double avgcompswordsfound = compsWordsFound / wordsFound;
        double avgcompswordsnotfound = compsWordsNotFound / wordsNotFound;

        System.out.println("Words Found: " + wordsFound);
        System.out.println("Words Not Found: " + wordsNotFound);
        System.out.println("Average Comparisons Found: " + avgcompswordsfound);
        System.out.println("Average Comparisons Not Found: " + avgcompswordsnotfound);

    }
}

/*
Output

run:
Words Found: 914054
Words Not Found: 64537
Average Comparisons Found: 16.0
Average Comparisons Not Found: 11.0
BUILD SUCCESSFUL (total time: 2 seconds)

*/