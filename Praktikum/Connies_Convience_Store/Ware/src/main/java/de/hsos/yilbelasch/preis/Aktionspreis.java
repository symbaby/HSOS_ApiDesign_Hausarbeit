package de.hsos.yilbelasch.preis;

import java.util.Date;
import java.util.Objects;

public class Aktionspreis extends Preis{
    private final Date gueltigBis;

    Aktionspreis(Geld preis, Date gueltigAb, Date gueltigBis) {
        super(preis, gueltigAb);
        this.gueltigBis = Objects.requireNonNull(gueltigBis);
    }

    public Date getGueltigBis(){
        return this.gueltigBis;
    }
}
