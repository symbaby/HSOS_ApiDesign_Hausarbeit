package de.hsos.api.entity;

import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;
import de.hsos.api.shared.dto.PriceDTO;

import java.util.Collection;
import java.sql.Date;

public interface IItemCatalogue {

    Collection <ItemDTO> getAllItems();

    ItemDTO getItem(Long id);

    boolean createItem(ItemCreationDTO itemDTO);

    boolean updateItem(Long id, ItemUpdateDTO itemDTO);

    boolean deleteItem(Long id);

    PriceDTO getPriceForDate(Long id, Date date);

    PriceDTO howMuchForQty(Long id, Integer qty);
}
