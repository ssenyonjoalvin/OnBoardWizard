package org.pahappa.systems.kpiTracker.views.debtor;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.kpiTracker.core.services.debtor.DebtorService;
import org.pahappa.systems.kpiTracker.models.debtor.Debtor;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.pahappa.systems.kpiTracker.security.HyperLinks;
import org.pahappa.systems.kpiTracker.security.UiUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.client.views.presenters.ViewPath;
import org.sers.webutils.model.RecordStatus;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ViewScoped
@ManagedBean(name="debtorView")
@Getter
@Setter
@ViewPath(path = HyperLinks.DEBTOR_VIEW)

public class DebtorsView extends PaginatedTableView<Debtor, DebtorsView, DebtorsView> {

    private DebtorService debtorService;
    private Search search;
    String searchTerm;

    @PostConstruct
    public void init(){
        this.debtorService = ApplicationContextProvider.getBean(DebtorService.class);
        this.reloadFilterReset();
    }

    @Override
    public void reloadFromDB(int i, int i1, Map<String, Object> map) throws Exception {
        super.setDataModels(debtorService.getInstances(this.search,i,0));
    }

    @Override
    public List<ExcelReport> getExcelReportModels() {
        return Collections.emptyList();
    }

    @Override
    public void reloadFilterReset() {
        search = new Search(Debtor.class);
        search.addFilterAnd(
                Filter.equal("recordStatus", RecordStatus.ACTIVE)
        );
        search.addSort("dateCreated", true);

        if (this.searchTerm != null && !this.searchTerm.isEmpty()) {
            search.addFilterILike("name", "%" + searchTerm + "%");
        }
        try {
            super.reloadFilterReset();
        } catch(Exception e) {
            UiUtils.ComposeFailure("Error", e.getLocalizedMessage());
        }

    }
    @Override
    public String getFileName() {
        return "";
    }

    @Override
    public List<Debtor> load(int i, int i1, Map<String, SortMeta> map, Map<String, FilterMeta> map1) {
        return Collections.emptyList();
    }

    public void deleteSelectedItem(Debtor debtor){
        try {
            debtorService.deleteInstance(debtor);
            this.reloadFilterReset();
//            UiUtils.ComposeSuccess("Success", "Item deleted successfully.");
        } catch (Exception e) {
            UiUtils.ComposeFailure("Error", e.getMessage());
        }
    }
}
