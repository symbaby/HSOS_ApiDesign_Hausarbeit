import de.hsos.yilbelasch.utils.WareManagement;
import de.hsos.yilbelasch.ware.WareManager;

module Ware {
    exports de.hsos.yilbelasch.utils;

    provides de.hsos.yilbelasch.utils.WareManagerFactory with de.hsos.yilbelasch.utils.WareManagerFactory;
    provides WareManagement with WareManager;
}