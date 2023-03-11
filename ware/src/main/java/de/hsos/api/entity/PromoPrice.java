package de.hsos.api.entity;


import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class PromoPrice extends Price {

    private Date expirationDate;
    private double discountPrice;

    public PromoPrice() {
    }
/*
    public PromoPrice(double price, Date effectiveDate, Date expirationDate) {
        super(price, effectiveDate);
        this.expirationDate = expirationDate;
    }
    */

    public PromoPrice(double price, Date effectiveDate, Date expirationDate, double discountPrice) {
        super(price, effectiveDate);
        this.expirationDate = expirationDate;
        this.discountPrice = discountPrice;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
