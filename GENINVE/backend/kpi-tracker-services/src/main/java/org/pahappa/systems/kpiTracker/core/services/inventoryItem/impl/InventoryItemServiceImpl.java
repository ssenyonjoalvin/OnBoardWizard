package org.pahappa.systems.kpiTracker.core.services.inventoryItem.impl;

import org.pahappa.systems.kpiTracker.core.services.impl.GenericServiceImpl;
import org.pahappa.systems.kpiTracker.core.services.inventoryItem.InventoryItemService;
import org.pahappa.systems.kpiTracker.models.inventoryItem.InventoryItem;
import org.pahappa.systems.kpiTracker.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryItemServiceImpl extends GenericServiceImpl<InventoryItem> implements InventoryItemService {
    @Override
    public boolean isDeletable(InventoryItem instance) throws OperationFailedException {
        return true;
    }

    @Override
    public InventoryItem saveInstance(InventoryItem entityInstance) throws ValidationFailedException, OperationFailedException {
        Validate.notNull(entityInstance, "Missing details");
        return save(entityInstance);
    }
}
