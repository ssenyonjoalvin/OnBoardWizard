package org.pahappa.systems.kpiTracker.models.inventoryItem;

import org.pahappa.systems.kpiTracker.models.constants.InventoryAvailibilityStatus;
import org.sers.webutils.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="inventoryItem")
public class InventoryItem  extends BaseEntity {
   private String name;
   private InventoryAvailibilityStatus inventoryAvailibilityStatus;
    private  double costPrice;
   private  double  sellingPrice;
   private  double openingStock;
   private  int orderedQty;
   private  int closingStock;
   private  double  profit;
   private  double loss;


@Column(name= "name" , nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(name= "itemCostPrice", nullable = false)
    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
@Column(name="itemSellingPrice", nullable = false)
    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Column(name="itemOpeningStock")
    public double getOpeningStock() {
        return openingStock;
    }

    public void setOpeningStock(double openingStock) {
        this.openingStock = openingStock;
    }
@Column(name="itemOrderedQty")
    public int getOrderedQty() {
        return orderedQty;
    }

    public void setOrderedQty(int orderedQty) {
        this.orderedQty = orderedQty;
    }
@Column(name="itemClosingStock")
    public int getClosingStock() {
        return closingStock;
    }

    public void setClosingStock(int closingStock) {
        this.closingStock = closingStock;
    }
@Column(name="profit")
    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public int hashCode() {
        // Persisted entities are identified by their ID
        return Objects.hash(super.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InventoryItem inventoryItem = (InventoryItem) o;
        return super.getId() != null && Objects.equals(super.getId(), inventoryItem.getId());
    }

    public String toString(){
        return this.name;
    }
}
