package de.hsos.api.gateway;


import de.hsos.api.entity.IItemCatalogue;
import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;
import de.hsos.api.shared.dto.PriceDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collection;


@ApplicationScoped
public class ItemRepository implements IItemCatalogue {



    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Collection<ItemDTO> getAllItems() {
        return null;
    }

    @Override
    @Transactional
    public ItemDTO getItem(Long id) {
        return null;
    }

    @Override
    @Transactional
    public boolean createItem(ItemCreationDTO itemDTO) {



        return false;
    }

    @Override
    @Transactional
    public boolean updateItem(Long id, ItemUpdateDTO itemUpdateDTO) {
        return false;
    }

    @Override
    @Transactional
    public boolean deleteItem(Long id) {
        return false;
    }


    @Override
    @Transactional
    public PriceDTO getPriceForDate(Long id, Date date) {
        return null;
    }

    @Override
    @Transactional
    public PriceDTO howMuchForQty(Long id, Integer qty) {
        return null;
    }


}
