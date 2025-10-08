package org.pahappa.systems.kpiTracker.models.constants;

public enum DebtStatus {
    PAID("paid"),
    OUTSTANDING("outstanding");

    private final String  displayName;

    DebtStatus(String displayName) {
        this.displayName = displayName;
    }

}
