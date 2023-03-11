package de.hsos.api.shared.dto;

public class ItemDTO {

    public String description;
    public String shortDescription;
    public PriceDTO price;
    public PromoPriceDTO promoPriceDTO;
    public BarcodeDTO barcodeDTO;

    public ItemDTO(){

    }

    public ItemDTO(String description, String shortDescription, PriceDTO price, BarcodeDTO barcodeDTO) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.price = price;
        this.barcodeDTO = barcodeDTO;
    }

    public ItemDTO(String description, String shortDescription, PriceDTO price, BarcodeDTO barcodeDTO, PromoPriceDTO promoPriceDTO) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.price = price;
        this.barcodeDTO = barcodeDTO;
        this.promoPriceDTO = promoPriceDTO;
    }
}
