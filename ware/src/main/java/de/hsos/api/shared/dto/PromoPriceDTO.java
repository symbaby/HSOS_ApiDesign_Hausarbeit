package de.hsos.api.shared.dto;

import java.sql.Date;

public class PromoPriceDTO {
    public Date expirationDate;
    public double discountPrice;

    public PromoPriceDTO(){
    }

    public PromoPriceDTO(Date expirationDate, double discountPrice){
        this.expirationDate = expirationDate;
        this.discountPrice = discountPrice;
    }
}
