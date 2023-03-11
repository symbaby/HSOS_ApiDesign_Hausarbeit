package de.hsos.api.control;

import de.hsos.api.gateway.ItemPanacheRepository;
import de.hsos.api.gateway.ItemRepository;
import de.hsos.api.shared.dto.PriceDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Date;

@ApplicationScoped
public class ProductInformationService implements IProductInformation{

    @Inject
    ItemPanacheRepository itemRepository;

    @Override
    public PriceDTO getPriceForDate(Long id, Date date) {
        return this.itemRepository.getPriceForDate(id, date);
    }


    @Override
    public PriceDTO howMuchForQty(Long id, Integer qty) {
        return this.itemRepository.howMuchForQty(id,qty);
    }
}
