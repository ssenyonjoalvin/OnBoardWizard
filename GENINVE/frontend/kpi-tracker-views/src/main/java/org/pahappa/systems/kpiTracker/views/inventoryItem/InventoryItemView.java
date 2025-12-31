package org.pahappa.systems.kpiTracker.views.inventoryItem;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.kpiTracker.core.services.inventoryItem.InventoryItemService;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.pahappa.systems.kpiTracker.security.HyperLinks;
import org.pahappa.systems.kpiTracker.security.UiUtils;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.client.views.presenters.ViewPath;
import org.sers.webutils.model.RecordStatus;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.utils.SearchField;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@ManagedBean(name="inventoryItemView")
@ViewScoped
@ViewPath(path = HyperLinks.INVENTORY_ITEM_VIEW)
@Setter
@Getter
public class InventoryItemView extends PaginatedTableView<InventoryItem,InventoryItemView,InventoryItemView> {
    private InventoryItemService inventoryItemService;
     String searchTerm;
    private Search search;
    private InventoryItem selectedInventoryItem;


    @PostConstruct
    public void init(){
        this.inventoryItemService = ApplicationContextProvider.getBean(InventoryItemService.class);
        this.reloadFilterReset();

    }

    @Override
    public void reloadFromDB(int i, int i1, Map<String, Object> map)throws Exception {
        super.setDataModels(inventoryItemService.getInstances(this.search,i,0));
    }

    @Override
    public void reloadFilterReset(){
        search = new Search(InventoryItem.class);
        search.addFilterAnd(
                Filter.equal("recordStatus", RecordStatus.ACTIVE)

        );
        search.addSort("dateCreated", true);

        if(this.searchTerm != null && !this.searchTerm.isEmpty()){
            search.addFilterILike("name", "%" + searchTerm + "%");
        }
        try {
            super.reloadFilterReset();
        } catch(Exception e) {
            UiUtils.ComposeFailure("Error", e.getLocalizedMessage());
        }
    }

    @Override
    public List<ExcelReport> getExcelReportModels() {
        return Collections.emptyList();
    }

    @Override
    public String getFileName() {
        return "InventoryItems";
    }

    @Override
    public List load(int i, int i1, Map map, Map map1) {
        //this method is only required by the class , but since we have the reloadFromDB
        //then we don't need to implementx
        return null;
    }
    public void deleteSelectedItem(InventoryItem inventoryItem){
        try {
            inventoryItemService.deleteInstance(inventoryItem);
            this.reloadFilterReset();
//            UiUtils.ComposeSuccess("Success", "Item deleted successfully.");
        } catch (Exception e) {
            UiUtils.ComposeFailure("Error", e.getMessage());
        }
    }
}
