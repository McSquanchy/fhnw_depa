package patterns.state.parser;

class FloatData {
    double m = 0, quo=10;
    int exp = 0, exp_sign = 1;
    double getValue() { return m * Math.pow(10, exp_sign * exp); }
}