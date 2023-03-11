package de.hsos.extern;

import de.hsos.yilbelasch.utils.WareManagement;
import de.hsos.yilbelasch.utils.WareManagerFactory;

public class Main {

    public static void main(String[] args) {
        // write your code here
        WareManagement wareManagement = WareManagerFactory.create();

        System.out.println(wareManagement.preisFuerAnzahl(3, 1));    
        System.out.println(wareManagement.printeInput("Hallo API Gruppe"));
    }
}
