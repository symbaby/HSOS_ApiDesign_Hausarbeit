package de.hsos.api.control;

import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;

import java.util.Collection;

public interface IItemCrud {

    Collection <ItemDTO> getAllItems();

    ItemDTO getItem(Long id);

    boolean createItem(ItemCreationDTO itemDTO);

    boolean updateItem(Long id, ItemUpdateDTO itemDTO);

    boolean deleteItem(Long id);

}
