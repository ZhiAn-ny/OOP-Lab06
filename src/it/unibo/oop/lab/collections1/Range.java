package it.unibo.oop.lab.collections1;

public class Range implements Iterable<Integer> {
	
	final private int start;
	final private int stop;
	
	public Range(final int start, final int stop) {
		this.start = start;
		this.stop = stop;
	}

	public java.util.Iterator<Integer> iterator() {
		return new Iterator(this.start, this.stop);
	}
	
	private static class Iterator implements java.util.Iterator<Integer>{
		private int current;
		private final int stop;
		
		public Iterator(final int start, final int stop) {
			this.current = start;
			this.stop = stop;
		}
		
		public Integer next() {
			return this.current++;
		}
		
		public boolean hasNext() {
			return this.current <= this.stop;
		}
	}

}
