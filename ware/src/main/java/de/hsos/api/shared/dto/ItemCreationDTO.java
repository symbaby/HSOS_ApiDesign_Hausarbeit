package de.hsos.api.shared.dto;




public class ItemCreationDTO {

     /*
    Just a playground for inserting a date object with swagger ui.
    We must use java.sql.Date for this to work smoothly sonst schrott

    @Temporal(TemporalType.TIMESTAMP)
    public Date date;

    public ItemCreationDTO(Date date){
        this.date = date;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    */

     /*
      Check Item Properties

    public Item item;

    public ItemCreationDTO(Item item) {
        this.item = item;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public ItemCreationDTO() {

    }
   */

    public String description;

    public String shortDescription;

    public BarcodeDTO barcodeDTO;

    public PriceDTO priceDTO;

    public PromoPriceDTO promoPriceDTO;

    public ItemCreationDTO(){}

    public ItemCreationDTO(String description, String shortDescription, BarcodeDTO barcodeDTO, PriceDTO priceDTO, PromoPriceDTO promoPriceDTO) {
        this.description = description;
        this.shortDescription = shortDescription;
        this.barcodeDTO = barcodeDTO;
        this.priceDTO = priceDTO;
        this.promoPriceDTO = promoPriceDTO;
    }
}
