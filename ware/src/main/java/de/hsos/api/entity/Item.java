package de.hsos.api.entity;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @SequenceGenerator(name = "itemNumber", sequenceName = "itemNumber_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemNumber")
    private Long id;
    private String description;
    private String shortDescription;

    @Embedded
    private Barcode barcode;

    @Embedded
    private Price price;

    @Embedded
    private PromoPrice promoPrice;

    @Version
    private long version; // Locking

    public Item() {
    }

    /*
    public Item(String description, String shortDescription) {
        this.description = description;
        this.shortDescription = shortDescription;
    }

    public Item(Long id, String description, String shortDescription) {
        this.id = id;
        this.description = description;
        this.shortDescription = shortDescription;
    }

    public Item(String description, String shortDescription, Barcode barcode, Price price) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.barcode = barcode;
        this.price = price;
    }
    */

    public Item(String description, String shortDescription, Barcode barcode, Price price, PromoPrice promoPrice) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.barcode = barcode;
        this.price = price;
        this.promoPrice = promoPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public PromoPrice getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(PromoPrice promoPrice) {
        this.promoPrice = promoPrice;
    }
}
