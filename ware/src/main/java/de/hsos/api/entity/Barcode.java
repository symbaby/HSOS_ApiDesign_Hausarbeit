package de.hsos.api.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Barcode {

    private String barcode;

    public Barcode() {

    }

    public Barcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
