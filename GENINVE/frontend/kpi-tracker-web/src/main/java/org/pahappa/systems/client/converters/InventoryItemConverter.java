package org.pahappa.systems.client.converters;

import org.pahappa.systems.kpiTracker.core.services.inventoryItem.InventoryItemService;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("inventoryItemConverter")
public class InventoryItemConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            InventoryItemService inventoryItemService = ApplicationContextProvider.getBean(InventoryItemService.class);
            return inventoryItemService.getInstanceByID(value);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof InventoryItem) {
            return ((InventoryItem) object).getId();
        }
        return null;
    }
}