package de.hsos.api.shared.dto;

import java.sql.Date;

public class PriceDTO{
    public double price;
    public Date effectiveDate;

    public PriceDTO(){}

    public PriceDTO(double price, Date effectiveDate){
        this.price = price;
        this.effectiveDate = effectiveDate;
    }

}
