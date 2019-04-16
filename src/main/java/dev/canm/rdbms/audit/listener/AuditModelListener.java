package dev.canm.rdbms.audit.listener;

import dev.canm.rdbms.audit.model.AuditModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

/**
 * AuditModel's listener.
 */
@Component
public class AuditModelListener {

    private static final String NO_PRINCIPAL = "NO_PRINCIPAL";

    @Autowired(required = false)
    private Authentication authentication;

    /**
     * Sets the principal and creation date.
     *
     * @param auditModel Model
     */
    @PrePersist
    public final void auditCreation(final AuditModel auditModel) {

        String createdBy = getPrincipal(authentication);
        auditModel.setCreatedBy(createdBy);
        auditModel.setCreatedDate(LocalDateTime.now(ZoneOffset.UTC));
    }

    /**
     * Sets the principal and date for update or soft-delete.
     *
     * @param auditModel Model
     */
    @PreUpdate
    public void auditUpdate(final AuditModel auditModel) {

        String principal = getPrincipal(authentication);
        if (!auditModel.isDeleted()) {
            auditModel.setUpdatedBy(principal);
            auditModel.setUpdatedDate(LocalDateTime.now(ZoneOffset.UTC));
        } else {
            auditModel.setDeletedBy(principal);
            auditModel.setDeleteDate(LocalDateTime.now(ZoneOffset.UTC));
        }
    }

    /**
     * Gets the principal from {@link Authentication} object, otherwise uses 'NO_PRINCIPAL' key.
     *
     * @param authentication Authentication for principal
     * @return Principal
     */
    private String getPrincipal(Authentication authentication) {
        return Optional.ofNullable(authentication)
            .map(Authentication::getPrincipal)
            .map(String::valueOf)
            .orElse(NO_PRINCIPAL);
    }

}
