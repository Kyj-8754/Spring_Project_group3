package com.codingbox.group3.em;

public enum Score {

	ZERO(0.0), HALF(0.5), ONE(1.0), ONE_AND_A_HALF(1.5), TWO(2.0), 
    TWO_AND_A_HALF(2.5), THREE(3.0), THREE_AND_A_HALF(3.5), 
    FOUR(4.0), FOUR_AND_A_HALF(4.5), FIVE(5.0);

    private final double value;

    Score(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
