package de.hsos.yilbelasch.utils;

import de.hsos.yilbelasch.preis.Preis;
import de.hsos.yilbelasch.steuer.Steuerkategorie;
import de.hsos.yilbelasch.ware.Ware;

import java.util.Date;

public interface WareManagement {

   

    /**
     * 
     * @param date   Datum ab dem der Preis berechnet werden soll.
     * @param wareId Id der Ware fuer die der Preis berechnet werden soll.
     * @return Preis der Ware fuer die angegebene Id ab dem angegebenen Datum.
     */
    Preis preisVonDatum(Date date, Integer wareId);

    /**
     * 
     * @param wareId Id der Ware fuer die der Preis berechnet werden soll.
     * @return Preis der Ware fuer die angegebene Id.
     *
     */
    int howManyOverIntervall(Integer wareId);

    /**
     * 
     * @param steuerkategorie Steuerkategorie fuer die der Preis berechnet werden
     *                        soll.
     * @param wareId          Id der Ware fuer die der Preis berechnet werden soll.
     * @return Preis der Ware fuer die angegebene Id und die angegebene
     *         Steuerkategorie.
     */

    Preis preisFuerSteuersatzkategorie(Steuerkategorie steuerkategorie, Integer wareId);

    /**
     * 
     * @param anzahl Anzahl der Ware fuer die der Preis berechnet werden soll.
     * @param wareId Id der Ware fuer die der Preis berechnet werden soll.
     * @return Preis der Ware fuer die angegebene Id und die angegebene Anzahl.
     *
     */
    Preis preisFuerAnzahl(int anzahl, Integer wareId);

    /**
     * 
     * @param ware Ware die hinzugefuegt werden soll.
     */
    void wareHinzufuegen(Ware ware);

    String printeInput(String input);
}
