package org.pahappa.systems.kpiTracker.views.inventoryItem;

import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.kpiTracker.core.services.inventoryItem.InventoryItemService;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.pahappa.systems.kpiTracker.security.HyperLinks;
import org.pahappa.systems.kpiTracker.utils.Validate;
import org.pahappa.systems.kpiTracker.views.dialogs.DialogForm;
import org.sers.webutils.client.views.presenters.ViewPath;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="inventoryFormDialog")
@Setter
@Getter
@ViewPath(path= HyperLinks.INVENTORY_ITEM_DIALOG)
@SessionScoped
public  class InventoryFormDialog extends DialogForm<InventoryItem> {
private InventoryItemService inventoryItemService;
//private InventoryItem inventoryItem;

    public  InventoryFormDialog(){
        super(HyperLinks.INVENTORY_ITEM_DIALOG ,500,600);
    }
    @PostConstruct
    public void init(){
        this.inventoryItemService = ApplicationContextProvider.getBean(InventoryItemService.class);
        //this.model = new InventoryItem();
    }
    @Override
    public void persist() throws Exception {
        Validate.notNull(this.model.getName(), "Inventory name cannot be null");
        inventoryItemService.saveInstance(super.model);

    }
    @Override
    public void resetModal(){
        super.resetModal();
   super.model = new InventoryItem();

    }
    @Override
    public void setFormProperties(){
        super.setFormProperties();
    }
}
