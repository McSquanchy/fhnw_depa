package patterns.state.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloatConverter0 {
	static double m = 0, quo = 10;
	static int exp = 0, exp_sign = 1;
	static int pos = 0;

	public static State state;

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		while (s != null && s.length() > 0) {
			resetValues();
			state = new State0();
			try {
				double d = parseFloat(s);
				System.out.println(d);
			} catch (IllegalArgumentException e) {
				System.out.println("Illegal Format");
			}
			s = r.readLine();
		}
	}

	private static void resetValues() {
		exp = 0;
		quo = 10;
		m = 0;
		pos = 0;
		exp_sign = 1;
	}

	private static boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	private static int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}
	
	private static double parseFloat(String str) {
		while (!(state instanceof StateError) && pos < str.length()) {
			char ch = str.charAt(pos++);
			state.handle(ch);

//			if(isDigit(ch)) {
//
//				if(s == State.S0) {
////					m = getNumericValue(ch);
////					state = new StateS1();
//				} else if(s == State.S1) {
//					m = 10 * m + getNumericValue(ch);
//				} else if(s == State.S2 || s == State.S3) {
//					m = m + getNumericValue(ch)/quo; quo = quo*10;
//					s = State.S3;
//				} else if(s == State.S4 || s == State.S5 || s == State.S6) {
//					exp = 10*exp + getNumericValue(ch);
//					s = State.S6;
//				} else {
//					s = State.ERROR;
//				}
//			} else if(ch == '.') {
//				if(s == State.S0) {
//					s = State.S2;
//				} else if(s == State.S1) {
//					s = State.S3;
//				} else {
//					s = State.ERROR;
//				}
//			} else if(ch == 'e' || ch == 'E') {
//				if(s == State.S1 || s == State.S3) {
//					s = State.S4;
//				} else {
//					s = State.ERROR;
//				}
//			} else if(ch == '+') {
//				if(s == State.S4) {
//					s = State.S5;
//				} else {
//					s = State.ERROR;
//				}
//			} else if(ch == '-') {
//				if(s == State.S4) {
//					exp_sign = -1;
//					s = State.S5;
//				} else {
//					s = State.ERROR;
//				}
//			}
		}
		
		if (state instanceof State3 || state instanceof State6) {
			System.out.println(m);
			return m * Math.pow(10, exp_sign * exp);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
//	private enum State {
//		S0, S1, S2, S3, S4, S5, S6, ERROR
//	}

	public static class State0 implements State {

		@Override
		public void handle(char ch) {
			if(isDigit(ch)) {
				m = getNumericValue(ch);
				state = new State1();
			} else {
				state = new State2();
			}

		}
	}

	public static class State1 implements State {
		@Override
		public void handle(char ch) {
			if(isDigit(ch)) {
				m = 10 * m + getNumericValue(ch);
			} else if (ch == '.') {
				state = new State3();
			} else if(ch == 'e' || ch == 'E') {
				state = new State4();
			}
		}
	}

	public static class State2 implements State {
		@Override
		public void handle(char ch) {
			if(isDigit(ch)) {
				m = m + getNumericValue(ch)/quo; quo = quo*10;
				state = new State3();
			} else {
				state = new StateError();
			}
		}
	}

	public static class State3 implements State {

		@Override
		public void handle(char ch) {
			if(isDigit(ch)) {
				m = m + getNumericValue(ch)/quo; quo = quo*10;
			} else if(ch == 'e' || ch == 'E') {
				state  = new State4();
			} else {
				state = new StateError();
			}
		}
	}

	public static class State4 implements State {

		@Override
		public void handle(char ch) {
			if(isDigit(ch)){
				exp = 10*exp + getNumericValue(ch);
				state = new State6();
			} else if(ch == '+') {
				state = new State5();
			} else if(ch == '-') {
				exp_sign = -1;
				state = new State5();
			} else {
				state = new StateError();
			}
		}
	}

	public static class State5 implements State {

		@Override
		public void handle(char ch) {
			if(isDigit(ch)) {
				exp = 10 * exp + getNumericValue(ch);
				state = new State6();
			} else {
				state = new StateError();
			}
		}
	}

	public static class State6 implements State {

		@Override
		public void handle(char ch) {
			if(isDigit(ch)) {
				exp = 10 * exp + getNumericValue(ch);
			}
			if(!isDigit(ch)) {
				state = new StateError();
			}
		}
	}

	static public class StateError implements State {

		@Override
		public void handle(char ch) {
//			System.out.println("Entered ErrorState!");
		}
	}

}
