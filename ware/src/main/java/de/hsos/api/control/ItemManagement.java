package de.hsos.api.control;

import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;
import de.hsos.api.shared.dto.PriceDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.sql.Date;

@ApplicationScoped
public class ItemManagement implements IItemCrud, IProductInformation {

    @Inject
    ItemService itemService;

    @Inject
    ProductInformationService productInformationService;


    @Override
    public Collection<ItemDTO> getAllItems() {
        return this.itemService.getAllItems();
    }

    @Override
    public ItemDTO getItem(Long id) {
        return this.itemService.getItem(id);
    }

    @Override
    public boolean createItem(ItemCreationDTO itemDTO) {
        return this.itemService.createItem(itemDTO);
    }

    @Override
    public boolean updateItem(Long id, ItemUpdateDTO itemDTO) {
        return this.itemService.updateItem(id, itemDTO);
    }

    @Override
    public boolean deleteItem(Long id) {
        return this.itemService.deleteItem(id);
    }

    @Override
    public PriceDTO getPriceForDate(Long id, Date date) {
        return this.productInformationService.getPriceForDate(id, date);
    }

    @Override
    public PriceDTO howMuchForQty(Long id, Integer qty) {
        return this.productInformationService.howMuchForQty(id, qty);
    }
}
