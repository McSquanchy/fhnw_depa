package patterns.state.parser;

public interface State {
    default State handleDigit(FloatData data, int val) { return null; }
    default State handleE(FloatData data) { return null; }
    default State handleDot(FloatData data) { return null; }
    default State handlePlus(FloatData data) { return null; }
    default State handleMinus(FloatData data) { return null; }
}