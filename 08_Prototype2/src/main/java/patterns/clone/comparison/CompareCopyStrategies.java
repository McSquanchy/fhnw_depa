package patterns.clone.comparison;

public class CompareCopyStrategies {
	private static final int SIZE = 10000;
	private static final int NOFCLONES = 1000;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		double referenceTime1 = measureOC(new Dictionary("german", SIZE));
		double referenceTime2 = measureCC(new DictionaryCC("german", SIZE));
		DictionaryCC a = new DictionaryCC("english", 500);
		DictionaryCC b = a.clone();
		System.out.println(b.getSize());
	}

	private static double measureOC(Dictionary dict) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < NOFCLONES; i++) {
			dict.clone();
		}
		long end = System.currentTimeMillis();
		double t = (end - start) / 1000.0;
		System.out.println("Time used: " + t);
		return t;
	}

	private static double measureCC(DictionaryCC dict) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < NOFCLONES; i++) {
			dict.clone();
		}
		long end = System.currentTimeMillis();
		double t = (end - start) / 1000.0;
		System.out.println("Time used: " + t);
		return t;
	}
}
