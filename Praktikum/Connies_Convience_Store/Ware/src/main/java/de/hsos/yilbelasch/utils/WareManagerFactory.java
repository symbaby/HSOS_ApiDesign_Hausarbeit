package de.hsos.yilbelasch.utils;

import de.hsos.yilbelasch.ware.WareManager;

public class WareManagerFactory {
    // return Typ WareManagement (Interface) oder WareManager (Typ)
    // Fragen welches besser ist wegen den Casten in der Main
    public static WareManager create() {
        WareManager wareManager = new WareManager();
        return wareManager;
    }
}
