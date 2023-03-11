package de.hsos.api.control;

import de.hsos.api.shared.dto.PriceDTO;

import java.sql.Date;

public interface IProductInformation {

    PriceDTO getPriceForDate(Long id, Date date);

    PriceDTO howMuchForQty(Long id, Integer qty);

}
