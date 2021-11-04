package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> aList = new ArrayList<Integer>();
    	for (final int i : new Range(1000, 2000 - 1)) {
    		aList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> lList = new LinkedList<Integer>(aList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int first = aList.get(aList.size() - aList.size());
    	aList.set(aList.size() - aList.size(), aList.get(aList.size() - (first / first)));
    	aList.set(aList.size() - (first / first), first);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (final int i : aList) {
    		System.out.println(i);
    	}
    	//System.out.println(aList);
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	
    	for (final int i : new Range (1, ELEMS)) {
    		aList.add(i + ELEMS);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS + " int in a ArrayList took " 
        		+ time + "ns (" + time / TO_MS + "ms)");
    	
        time = System.nanoTime();
    	
    	for (final int i : new Range (1, ELEMS)) {
    		lList.add(i + ELEMS);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS + " int in a LinkedList took " 
        		+ time + "ns (" + time / TO_MS + "ms)");
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
    	
    	for (final int i : new Range (1, 1000)) {
    		aList.get(aList.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Reading " + 1000 
        		+ " int from the middle of an ArrayList took " 
        		+ time + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime();
    	
    	for (final int i : new Range (1, 1000)) {
    		lList.get(aList.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Reading " + 1000 
        		+ " int from the middle of an LinkedList took " 
        		+ time + "ns (" + time / TO_MS + "ms)");
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        final Map<String, Double> map = new HashMap<>();
        map.put("Africa", 1_110_635_000.0);
        map.put("Americas", 972_005_000.0);
        map.put("Antartica", 0.0);
        map.put("Asia", 4_298_723_000.0);
        map.put("Europe", 742_452_000.0);
        map.put("Oceania", 38_304_000.0);
        
        
        /*
         * 8) Compute the population of the world
         */
        double gPop = 0;
        for (final Map.Entry<String, Double> entry : map.entrySet()) {
        	gPop += entry.getValue();
        }
        
    }
}
