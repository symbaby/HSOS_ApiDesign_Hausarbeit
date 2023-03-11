package de.hsos.yilbelasch.ware;

import de.hsos.yilbelasch.preis.Geld;
import de.hsos.yilbelasch.preis.Preis;
import de.hsos.yilbelasch.preis.Waehrung;
import de.hsos.yilbelasch.steuer.Kategorie;
import de.hsos.yilbelasch.steuer.Steuerkategorie;
import de.hsos.yilbelasch.utils.WareManagement;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WareManager implements WareManagement {
    private Map<Integer, Ware> waren;

    public WareManager() {
        this.waren = new HashMap<>();

        // Negativbeispiel
        // Ware w1 = new Ware(1, new Beschreibung("Gucci Schuhe"), new Barcode("123456789111"), new Preis(new Geld(Waehrung.EURO, 300), new Date(2000, 1, 1)));
        // Ware w2 = new Ware(2, new Beschreibung("Gucci Bauchtasche"), new Barcode("123456789111"), new Preis(new Geld(Waehrung.EURO, 800), new Date(2000, 1, 1)));
        // Ware w3 = new Ware(3, new Beschreibung("Gucci Guertel"), new Barcode("123456789111"), new Preis(new Geld(Waehrung.EURO, 400), new Date(2000, 1, 1)));

        // Besser mit Builder
        // ToBeDone....
        Ware w1 = new Ware.WareBuilder().addBeschreibung(new Beschreibung("Gucci Schuhe"))
                .addNummer(1)
                .addBarcode(new Barcode("123456789111"))
                .addPreis(new Preis(new Geld(Waehrung.EURO, 300), new Date(2000, 1, 1))) // AddPreis noch haessichlich
                .addSteuerkategorie(new Steuerkategorie(Kategorie.MEHRWERTSTEUER, new Date(2000, 1, 1))) // AddSteuerkategorie noch haessichlich
                .build();

        Ware w2 = new Ware.WareBuilder().addBeschreibung(new Beschreibung("Gucci Bauchtasche"))
                .addNummer(2)
                .addBarcode(new Barcode("123456789111"))
                .addPreis(new Preis(new Geld(Waehrung.LIRA, 800), new Date(2000, 1, 1)))
                .addSteuerkategorie(new Steuerkategorie(Kategorie.MEHRWERTSTEUER, new Date(2000, 1, 1)))
                .build();

        Ware w3 = new Ware.WareBuilder().addBeschreibung(new Beschreibung("Gucci Guertel"))
                .addNummer(3)
                .addBarcode(new Barcode("123456789111"))
                .addPreis(new Preis(new Geld(Waehrung.DOLLAR, 400), new Date(2000, 1, 1)))
                .addSteuerkategorie(new Steuerkategorie(Kategorie.MEHRWERTSTEUER, new Date(2000, 1, 1)))
                .build();


        waren.put(w1.getNummer(), w1);
        waren.put(w2.getNummer(), w2);
        waren.put(w3.getNummer(), w3);

    }


    @Override
    public void wareHinzufuegen(Ware ware) {
        if (!waren.containsKey(ware.getNummer()) || !waren.containsValue(ware)) {
            this.waren.put(ware.getNummer(), ware);
        } else {
            throw new RuntimeException("Ware gibt es bereits");
        }

    }

    @Override
    public String printeInput(String input) {
        return input;
    }

    @Override
    public Preis preisVonDatum(Date date, Integer wareId) {
        return this.waren.get(wareId).getPriceForDate(date);
    }

    @Override
    public int howManyOverIntervall(Integer wareId) {
        return this.waren.get(wareId).howManyOverIntervall();
    }

    @Override
    public Preis preisFuerSteuersatzkategorie(Steuerkategorie steuerkategorie, Integer wareId) {
        return this.waren.get(wareId).howMuchForTaxCat(steuerkategorie);
    }

    @Override
    public Preis preisFuerAnzahl(int anzahl, Integer wareId) {
        return this.waren.get(wareId).howMuchForQty(anzahl);
    }



}
