package de.hsos.api.shared.dto;

import de.hsos.api.entity.PromoPrice;

public class ItemUpdateDTO {


    public String description;

    public String shortDescription;

    public PriceDTO priceDTO;

    public PromoPriceDTO promoPriceDTO;

    public ItemUpdateDTO(){}

    /*
    public ItemUpdateDTO(String description, String shortDescription, PriceDTO priceDTO) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.priceDTO = priceDTO;
    }

     */


    public ItemUpdateDTO(String description, String shortDescription, PriceDTO priceDTO, PromoPriceDTO promoPriceDTO) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.priceDTO = priceDTO;
        this.promoPriceDTO = promoPriceDTO;
    }



}
