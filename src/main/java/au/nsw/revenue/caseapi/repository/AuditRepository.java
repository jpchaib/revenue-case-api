package au.nsw.revenue.caseapi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import au.nsw.revenue.caseapi.model.AuditLog;

public interface AuditRepository extends MongoRepository<AuditLog, String> {
    List<AuditLog> findByCaseId(String caseId);
}