package org.pahappa.systems.kpiTracker.models.debtor;

import lombok.Setter;
import org.pahappa.systems.kpiTracker.models.constants.DebtStatus;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.sers.webutils.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
//import

@Setter
@Entity
@Table(name="debtors")
public class Debtor extends BaseEntity {

    private String name;
    private InventoryItem inventoryItem;
    private double itemQty;
    private  double amount;
    private  String  phone;
    private double debtPaid;
    private double debtRemaining;
    private Date dateDebtTaken;
    private DebtStatus  status;

    @Column(name="debt_remaining")
    public double getDebtRemaining() {
        return debtRemaining;
    }

    @Column(name="debt_paid")
    public double getDebtPaid() {
        return debtPaid;
    }

    public String getName() {
        return name;
    }

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "item_id")
    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }
@Column(name="itemQtyOrdered")
    public double getItemQty() {
        return itemQty;
    }
@Column(name="amount")
    public double getAmount() {
        return amount;
    }
@Column(name="phoneNumber")
    public String getPhone() {
        return phone;
    }
@Column(name ="dateDebtTaken")
    public Date getDateDebtTaken() {
        return dateDebtTaken;
    }
@Column(name="status")
    public DebtStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Debtor debtor = (Debtor) o;
        return itemQty == debtor.itemQty && Double.compare(amount, debtor.amount) == 0 && phone == debtor.phone && Double.compare(debtPaid, debtor.debtPaid) == 0 && Double.compare(debtRemaining, debtor.debtRemaining) == 0 && Objects.equals(name, debtor.name) && Objects.equals(inventoryItem, debtor.inventoryItem) && Objects.equals(dateDebtTaken, debtor.dateDebtTaken) && status == debtor.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventoryItem, itemQty, amount, phone, dateDebtTaken, status,debtRemaining,debtPaid);
    }
}
