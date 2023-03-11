package de.hsos.yilbelasch.ware;

import de.hsos.yilbelasch.preis.Preis;

import java.util.Objects;

public class WareDTO {
    
    // Moegliche WareDTO Implementation...
    // Transport an andere Module die nicht die komplette Information von Ware brauchen.
    private int nummer;
    private Beschreibung beschreibung;
    private Preis preis;

    public static WareDTO wareToDTO(Ware ware) {
        WareDTO wareDTO = new WareDTO();

        wareDTO.nummer = ware.getNummer();
        wareDTO.beschreibung = Objects.requireNonNull(ware.getBeschreibung());
        wareDTO.preis = Objects.requireNonNull(ware.getPreis());

        return wareDTO;
    }
}
