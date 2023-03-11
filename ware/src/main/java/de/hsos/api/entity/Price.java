package de.hsos.api.entity;

import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class Price {

    private double price;
    private Date effectiveDate;


    public Price(double price, Date effectiveDate) {
        this.price = price;
        this.effectiveDate = effectiveDate;
    }

    public Price() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
