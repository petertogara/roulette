package com.playsafe.roullette.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import static org.apache.commons.lang3.StringUtils.isNumeric;

@Getter
@AllArgsConstructor
public enum BetType {
    NUMBER(),
    ODD_EVEN();

    private double multiplier;

    public static BetType lookup(final String bet) {
        return isNumeric(bet) ? NUMBER : ODD_EVEN;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
