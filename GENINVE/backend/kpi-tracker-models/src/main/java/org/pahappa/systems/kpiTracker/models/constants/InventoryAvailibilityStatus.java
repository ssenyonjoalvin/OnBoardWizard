package org.pahappa.systems.kpiTracker.models.constants;

public enum InventoryAvailibilityStatus {
    INSTOCK("Instock"),
    OUTOFSTOCK("Out_Of_Stock"),
    ALMOSTOUTOFSTOCK("Almost_Out_Of_Stock");

    private final String  displayName;
    InventoryAvailibilityStatus(String displayName){
        this.displayName = displayName;
    }

}
