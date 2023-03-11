package de.hsos.api.control;

import de.hsos.api.gateway.ItemPanacheRepository;
import de.hsos.api.gateway.ItemRepository;
import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ItemService implements IItemCrud{

    @Inject
    ItemPanacheRepository itemRepository;

    @Override
    public Collection<ItemDTO> getAllItems() {
        return this.itemRepository.getAllItems();
    }

    @Override
    public ItemDTO getItem(Long id) {
        return this.itemRepository.getItem(id);
    }

    @Override
    public boolean createItem(ItemCreationDTO itemDTO) {
        return this.itemRepository.createItem(itemDTO);
    }

    @Override
    public boolean updateItem(Long id, ItemUpdateDTO itemDTO) {
        return this.itemRepository.updateItem(id, itemDTO);
    }

    @Override
    public boolean deleteItem(Long id) {
        return this.itemRepository.deleteItem(id);
    }
}
