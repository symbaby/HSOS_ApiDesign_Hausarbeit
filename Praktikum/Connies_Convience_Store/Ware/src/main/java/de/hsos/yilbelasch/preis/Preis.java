package de.hsos.yilbelasch.preis;

import java.util.Date;
import java.util.Objects;

public class Preis {
    private Geld geld;
    private Date gueltigAb;

    public Preis(Geld preis, Date gueltigAb) {
        this.geld = Objects.requireNonNull(preis);
        this.gueltigAb = Objects.requireNonNull(gueltigAb);
    }

    private Preis() {

    }

    public Geld getGeld() {
        return geld;
    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    @Override
    public String toString() {
        return "Preis = " + geld;
    }

    public static class PreisBuilder {
        private final Preis preis;

        public PreisBuilder() {
            this.preis = new Preis();
        }

        public PreisBuilder addGeld(Geld geld) {
            this.preis.geld = Objects.requireNonNull(geld);
            return this;
        }

        public PreisBuilder addGueltigkeitsdatum(Date date) {
            this.preis.gueltigAb = Objects.requireNonNull(date);
            return this;
        }

        public Preis build() {
            return this.preis;
        }
    }
}
