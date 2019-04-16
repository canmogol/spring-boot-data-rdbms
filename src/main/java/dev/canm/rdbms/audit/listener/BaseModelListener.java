package dev.canm.rdbms.audit.listener;

import dev.canm.rdbms.audit.model.BaseModel;

import javax.persistence.PreRemove;

/**
 * BaseModel's listener, prevents BaseModel deletion.
 */
public class BaseModelListener {

    /**
     * Prevents deletion of BaseModel.
     *
     * @param baseModel {@link BaseModel}
     */
    @PreRemove
    public final void auditDelete(final BaseModel<?> baseModel) {
        throw new IllegalStateException("Cannot delete/remove BaseModel, "
            + "use Repository method to delete instead, model: "
            + baseModel.getClass().getName() + " id: " + baseModel.getId());
    }

}
