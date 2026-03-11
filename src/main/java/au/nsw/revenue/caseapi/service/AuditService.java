package au.nsw.revenue.caseapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import au.nsw.revenue.caseapi.model.AuditLog;
import au.nsw.revenue.caseapi.repository.AuditRepository;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;

    public void log(String caseId, String action, String actor) {
        auditRepository.save(AuditLog.builder()
                .caseId(caseId)
                .action(action)
                .actor(actor)
                .timestamp(Instant.now())
                .build());
    }

    public List<AuditLog> findByCaseId(String caseId) {
        return auditRepository.findByCaseId(caseId);
    }
}