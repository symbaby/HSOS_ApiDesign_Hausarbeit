package de.hsos.api.shared.converter;

import de.hsos.api.entity.Barcode;
import de.hsos.api.entity.Item;
import de.hsos.api.entity.Price;
import de.hsos.api.entity.PromoPrice;
import de.hsos.api.shared.dto.*;

public class DTOConverter {

    public static ItemDTO toItemDTO(Item item) {
        return new ItemDTO(item.getDescription(), item.getShortDescription(),
                DTOConverter.toPriceDTO(item.getPrice()),
                DTOConverter.toBarcodeDTO(item.getBarcode()),
                DTOConverter.toPromoPriceDTO(item.getPromoPrice())
        );
    }

    public static PromoPriceDTO toPromoPriceDTO(PromoPrice promoPrice) {
        return new PromoPriceDTO(promoPrice.getExpirationDate(), promoPrice.getDiscountPrice());
    }

    public static PriceDTO toPriceDTO(Price price) {
        return new PriceDTO(price.getPrice(), price.getEffectiveDate());
    }

    public static BarcodeDTO toBarcodeDTO(Barcode barcode) {
        return new BarcodeDTO(barcode.getBarcode());
    }

    public static Item fromItemDTO(ItemCreationDTO itemDTO) {

        return new Item(itemDTO.description, itemDTO.shortDescription,
                DTOConverter.fromBarcodeDTO(itemDTO.barcodeDTO),
                DTOConverter.fromPriceDTO(itemDTO.priceDTO),
                DTOConverter.fromPromoPriceDTO(itemDTO.priceDTO, itemDTO.promoPriceDTO)
        );
    }

    public static PromoPrice fromPromoPriceDTO(PriceDTO priceDTO, PromoPriceDTO promoPriceDTO) {
        return new PromoPrice(priceDTO.price, priceDTO.effectiveDate, promoPriceDTO.expirationDate, promoPriceDTO.discountPrice);
    }

    public static Price fromPriceDTO(PriceDTO priceDTO) {
        return new Price(priceDTO.price, priceDTO.effectiveDate);
    }

    public static Barcode fromBarcodeDTO(BarcodeDTO barcodeDTO) {
        return new Barcode(barcodeDTO.barcode);
    }


}
