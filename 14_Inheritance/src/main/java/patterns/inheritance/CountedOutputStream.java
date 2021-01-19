package patterns.inheritance;

import java.io.*;

public class CountedOutputStream extends StringOutputStream {

	private int count = 0;

	public CountedOutputStream(OutputStream s) {
		super(s);
	}

	public int writtenChars() {
		return count;
	}

	@Override
	public void write(char ch) throws IOException {
		int tmp = count;
		super.write(ch);
		count = tmp;
	}

	@Override
	public void write(String s) throws IOException {
		int tmp = count+s.length();
		super.write(s);
		count = tmp;
	}
}

