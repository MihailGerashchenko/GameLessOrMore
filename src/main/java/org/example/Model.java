package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The game aimed at those who need to have fun. Such game calm you down so you will keen it on.
 *
 * @author Mihail Gerashchenko
 * @version 9.0 30 August 2021
 */
public class Model {
    private int minBarrier;
    private int maxBarrier;
    private int secretValue;

    private List<Integer> yourWay = new ArrayList<Integer>();

    // [1-99]
    public int setSecretValue() {
        secretValue = (int) Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
        return secretValue;
    }

    public boolean checkValue(int value) {
        yourWay.add(value);
        if (value == secretValue) {
            return false;
        } else if (value > secretValue) {
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
        return true;
    }

    public boolean setPrimaryBarrier(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
        return true;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public List<Integer> getYourWay() {
        return yourWay;
    }

}