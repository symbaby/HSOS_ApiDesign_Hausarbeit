package de.hsos.yilbelasch.preis;

import java.util.Objects;

public class Geld {
    private final Waehrung waehrung;
    private final double betrag;

    public Geld(Waehrung waehrung, double betrag) {
        this.waehrung = Objects.requireNonNull(waehrung);
        this.betrag = betrag;
    }

    public Waehrung getWaehrung() {
        return waehrung;
    }

    public double getBetrag() {
        return betrag;
    }

    @Override
    public String toString() {
        return betrag + " " + waehrung;
    }
}
