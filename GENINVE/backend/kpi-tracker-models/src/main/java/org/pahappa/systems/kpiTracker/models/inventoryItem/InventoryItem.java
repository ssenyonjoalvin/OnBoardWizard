package org.pahappa.systems.kpiTracker.models.inventoryItem;

import org.sers.webutils.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="inventoryItem")
public class InventoryItem  extends BaseEntity {
   private String name;
   private  double costPrice;
   private  double  sellingPrice;
   private  int openingStock;
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
    public int getOpeningStock() {
        return openingStock;
    }

    public void setOpeningStock(int openingStock) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem that = (InventoryItem) o;
        return Double.compare(costPrice, that.costPrice) == 0 && Double.compare(sellingPrice, that.sellingPrice)
                == 0 && openingStock == that.openingStock && orderedQty == that.orderedQty && closingStock ==
                that.closingStock && Double.compare(profit, that.profit) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, costPrice, sellingPrice, openingStock, orderedQty, closingStock, profit, loss);
    }
}
