package patterns.state.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FloatConverter3 {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        while (s != null && s.length() > 0) {
            try {
                double d = parseFloat(s);
                System.out.println(d);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal Format");
            }
            s = r.readLine();
        }
    }

    private static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private static int getNumericValue(char ch) {
        return Character.getNumericValue(ch);
    }

    private static double parseFloat(String str) {
        State s = S0; // initial state
        FloatData data = new FloatData();
        int pos = 0;
        while (s != ERROR && pos < str.length()) {
            char ch = str.charAt(pos++);
            if (Character.isDigit(ch)) s = s.handleDigit(data,
                    Character.getNumericValue(ch));
            else if (ch == '.') s = s.handleDot(data);
            else if (ch == '+') s = s.handlePlus(data);
            else if (ch == '-') s = s.handleMinus(data);
            else if (ch == 'E') s = s.handleE(data);
            else if (ch == 'e') s = s.handleE(data);
            else s = ERROR;
        }
        if (s == S3 || s == S6) {
            return data.getValue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private enum State {
        S0, S1, S2, S3, S4, S5, S6, ERROR
    }
}
