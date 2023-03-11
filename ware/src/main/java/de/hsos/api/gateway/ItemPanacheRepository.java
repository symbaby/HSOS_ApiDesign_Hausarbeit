package de.hsos.api.gateway;

import de.hsos.api.entity.IItemCatalogue;
import de.hsos.api.entity.Item;
import de.hsos.api.shared.converter.DTOConverter;
import de.hsos.api.shared.dto.ItemCreationDTO;
import de.hsos.api.shared.dto.ItemDTO;
import de.hsos.api.shared.dto.ItemUpdateDTO;
import de.hsos.api.shared.dto.PriceDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@RequestScoped
public class ItemPanacheRepository implements PanacheRepository<Item>, IItemCatalogue {

    @Override
    @Transactional
    public Collection<ItemDTO> getAllItems() {

        Collection<Item> items = listAll();
        Collection<ItemDTO> dtoList = new ArrayList<>();

        for (Item item : items) {
            dtoList.add(DTOConverter.toItemDTO(item));
        }

        return dtoList;
    }

    @Override
    @Transactional
    public ItemDTO getItem(Long id) {

        Item item = findById(id);

        return DTOConverter.toItemDTO(item);
    }

    @Override
    @Transactional
    public boolean createItem(ItemCreationDTO itemDTO) {


        if (itemDTO != null) {
            Item item = DTOConverter.fromItemDTO(itemDTO);
            persist(item);

            return true;

        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean updateItem(Long id, ItemUpdateDTO itemDTO) {
        Item item = findById(id);

        if (item != null) {

            item.setDescription(itemDTO.description);
            item.setShortDescription(itemDTO.shortDescription);
            item.setPrice(DTOConverter.fromPriceDTO(itemDTO.priceDTO));
            item.setPromoPrice(DTOConverter.fromPromoPriceDTO(itemDTO.priceDTO, itemDTO.promoPriceDTO));
            return true;
        } else {

            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteItem(Long id) {

        return deleteById(id);
    }

    @Override
    @Transactional
    public PriceDTO getPriceForDate(Long id, Date date) {
        Item item = findById(id);
        System.out.println(item.getPromoPrice().getPrice());


        // PromoPrice is expired
        if (item.getPromoPrice().getExpirationDate() == null || date.compareTo(item.getPromoPrice().getExpirationDate()) > 0) {
            return DTOConverter.toPriceDTO(item.getPrice());


            // PromoPrice is not expired
        } else if (item.getPromoPrice().getExpirationDate() != null || date.compareTo(item.getPromoPrice().getExpirationDate()) < 0 || date.compareTo(item.getPromoPrice().getExpirationDate()) == 0) {
            return new PriceDTO(item.getPromoPrice().getDiscountPrice(), item.getPromoPrice().getExpirationDate());
        }

        return null;
    }

    @Override
    @Transactional
    public PriceDTO howMuchForQty(Long id, Integer qty) {
        Item item = findById(id);

        if (item != null && qty >= 1) {
            return new PriceDTO(item.getPrice().getPrice() * qty, item.getPrice().getEffectiveDate());
        }

        return null;

    }

    // @TODO: for self-study: try Panache instead of JPA...
    // https://quarkus.io/guides/hibernate-orm-panache

}
