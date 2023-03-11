package de.hsos.yilbelasch.ware;

import de.hsos.yilbelasch.preis.Aktionspreis;
import de.hsos.yilbelasch.preis.Geld;
import de.hsos.yilbelasch.preis.Preis;
import de.hsos.yilbelasch.steuer.Steuerkategorie;

import java.util.Date;
import java.util.Objects;

public class Ware {
    private int nummer;
    private Beschreibung beschreibung;
    private Steuerkategorie steuerkategorie;
    private Barcode barcode;
    private Preis preis;
    private Aktionspreis aktionspreis;

    Ware() {

    }

    Ware(int nummer, Beschreibung beschreibung, Barcode barcode, Preis preis) {
        this.nummer = nummer;
        this.beschreibung = Objects.requireNonNull(beschreibung);
        this.barcode = Objects.requireNonNull(barcode);
        this.preis = Objects.requireNonNull(preis);
    }


    // Preis holen und pruefen ob das Aktionspreis oder normalen Preis hat
    Preis getPriceForDate(Date date) {
        if (aktionspreis == null) {
            return this.preis;
        } else {
            if (date.before(this.aktionspreis.getGueltigBis())) {
                return this.aktionspreis;
            } else {
                return this.preis;
            }
        }
    }

    int getNummer() {
        return nummer;
    }

    // ???
    int howManyOverIntervall() {
        return 0;
    }

    // + wv Steuer
    Preis howMuchForTaxCat(Steuerkategorie steuerkategorie) {
        // Preis preis = new Preis(new Geld(this.getPreis().getPreis().getWaehrung(), this.getPreis().getPreis().getBetrag() * steuerkategorie.getSteuersatz()), this.getPreis().getGueltigAb());

        // Object Value Geld sehr aufwaendig beim instanziieren...
        return new Preis.PreisBuilder()
                .addGeld(new Geld(this.getPreis().getGeld().getWaehrung(), this.getPreis().getGeld().getBetrag() * steuerkategorie.getSteuersatz()))
                .addGueltigkeitsdatum(this.getPreis().getGueltigAb())
                .build();

    }

    // Staffelpreis ?
    Preis howMuchForQty(int anzahl) {
        // Preis preis = new Preis(new Geld(this.getPreis().getGeld().getWaehrung(), this.getPreis().getGeld().getBetrag() * anzahl), this.getPreis().getGueltigAb());

        // Object Value Geld sehr aufwaendig beim instanziieren...
        return new Preis.PreisBuilder()
                .addGeld(new Geld(this.getPreis().getGeld().getWaehrung(), this.getPreis().getGeld().getBetrag() * anzahl))
                .build();
    }


    Preis getPreis() {
        return this.preis;
    }

    Beschreibung getBeschreibung() {
        return this.beschreibung;
    }


    static class WareBuilder {
        private final Ware ware;

        public WareBuilder() {
            this.ware = new Ware();
        }

        public WareBuilder addNummer(int nummer) {
            this.ware.nummer = nummer;
            return this;
        }

        public WareBuilder addBeschreibung(Beschreibung beschreibung) {
            this.ware.beschreibung = Objects.requireNonNull(beschreibung);
            return this;
        }

        public WareBuilder addSteuerkategorie(Steuerkategorie steuerkategorie) {
            this.ware.steuerkategorie = Objects.requireNonNull(steuerkategorie);
            return this;
        }

        public WareBuilder addBarcode(Barcode barcode) {
            this.ware.barcode = Objects.requireNonNull(barcode);
            return this;
        }

        public WareBuilder addPreis(Preis preis) {
            this.ware.preis = Objects.requireNonNull(preis);
            return this;
        }

        public WareBuilder addAktionspreis(Aktionspreis aktionspreis) {
            this.ware.aktionspreis = Objects.requireNonNull(aktionspreis);
            return this;
        }

        public Ware build() {
            return this.ware;
        }
    }
}
