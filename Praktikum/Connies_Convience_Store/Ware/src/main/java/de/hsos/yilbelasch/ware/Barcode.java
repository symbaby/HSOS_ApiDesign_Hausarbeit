package de.hsos.yilbelasch.ware;

public class Barcode {
    // UPC: universal product code
    private String nummer;

    public Barcode(String nummer) {
        this.setNummer(nummer);
    }

    private void setNummer(String nummer) {
        String s = String.valueOf(nummer);
        if (s.length() == 12) {
            this.nummer = nummer;
        } else {
            throw new RuntimeException("Die Laenge des Barcodes muss 12 sein!");
        }
    }
}
