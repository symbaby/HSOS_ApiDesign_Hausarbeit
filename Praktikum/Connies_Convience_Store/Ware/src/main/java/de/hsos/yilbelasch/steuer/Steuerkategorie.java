package de.hsos.yilbelasch.steuer;

import java.util.Date;
import java.util.Objects;

public class Steuerkategorie {
    private final Kategorie kategorie;
    private Date gueltigAb;
    private double steuersatz;

    public Steuerkategorie(Kategorie kategorie, Date gueltigAb) {
        this.kategorie = Objects.requireNonNull(kategorie);
        this.gueltigAb = Objects.requireNonNull(gueltigAb);
        this.setSteuersatz();
    }

    private void setSteuersatz() {
        switch (kategorie) {
            case GRUNDNAHRUNGSSTEUER -> {
                this.steuersatz = 1.07;
            }
            case MEHRWERTSTEUER -> {
                this.steuersatz = 1.19;
            }
        }
    }

    public double getSteuersatz() {
        return steuersatz;
    }
}
