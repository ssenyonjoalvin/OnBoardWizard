package org.pahappa.systems.kpiTracker.core.services.debtor.impl;

import org.pahappa.systems.kpiTracker.core.services.debtor.DebtorService;
import org.pahappa.systems.kpiTracker.core.services.impl.GenericServiceImpl;
import org.pahappa.systems.kpiTracker.models.debtor.Debtor;
import org.pahappa.systems.kpiTracker.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DebtorServiceImpl extends GenericServiceImpl<Debtor> implements DebtorService {
    @Override
    public boolean isDeletable(Debtor instance) throws OperationFailedException {
        return true;
    }

    @Override
    public Debtor saveInstance(Debtor entityInstance) throws ValidationFailedException, OperationFailedException {
        Validate.notNull(entityInstance, "Missing details");
        return save(entityInstance);
    }
}
