package org.pahappa.systems.kpiTracker.views.debtor;

import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.kpiTracker.core.services.debtor.DebtorService;
import org.pahappa.systems.kpiTracker.core.services.inventoryItem.InventoryItemService;
import org.pahappa.systems.kpiTracker.models.constants.DebtStatus;
import org.pahappa.systems.kpiTracker.models.debtor.Debtor;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.pahappa.systems.kpiTracker.security.HyperLinks;
import org.pahappa.systems.kpiTracker.utils.Validate;
import org.pahappa.systems.kpiTracker.views.dialogs.DialogForm;
import org.sers.webutils.client.views.presenters.ViewPath;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name="debtorsDialogForm")
@SessionScoped
@Getter
@Setter
@ViewPath(path = HyperLinks.DEBTOR_DIALOG_FORM)

public class DebtorsDialogForm extends DialogForm<Debtor> {
    private DebtorService debtorService;
    private InventoryItemService inventoryItemService;


    private List<InventoryItem> inventoryItem;


    public DebtorsDialogForm() {
        super(HyperLinks.DEBTOR_DIALOG_FORM,500,300);
    }

    @PostConstruct
    public void init(){
        this.debtorService = ApplicationContextProvider.getBean(DebtorService.class);
        this.inventoryItemService = ApplicationContextProvider.getBean(InventoryItemService.class);
        this.inventoryItem = this.inventoryItemService.getAllInstances();
        super.resetModal();
    }
    @Override
    public void persist() throws Exception {
        Validate.notNull(this.model, "Missing goal details");

            super.model.setStatus(DebtStatus.OUTSTANDING);
            debtorService.saveInstance(super.model);


    }

    @Override
    public void resetModal(){
        super.resetModal();
        super.model = new Debtor();

    }
}
