package au.nsw.revenue.caseapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import au.nsw.revenue.caseapi.model.CaseNote;
import au.nsw.revenue.caseapi.model.CaseRecord;
import au.nsw.revenue.caseapi.repository.CaseRepository;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;
    private final AuditService auditService;

    public List<CaseRecord> getAllCases() {
        return caseRepository.findAll();
    }

    public CaseRecord getCaseById(String id) {
        return caseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));
    }

    public CaseRecord createCase(CaseRecord input) {
        input.setCreatedAt(Instant.now());
        input.setUpdatedAt(Instant.now());
        CaseRecord saved = caseRepository.save(input);
        auditService.log(saved.getId(), "CASE_CREATED", "System");
        return saved;
    }

    public CaseRecord updateStatus(String id, String newStatus, String actor) {
        CaseRecord record = getCaseById(id);
        record.setStatus(newStatus);
        record.setUpdatedAt(Instant.now());
        CaseRecord updated = caseRepository.save(record);
        auditService.log(id, "STATUS_UPDATED_TO_" + newStatus, actor);
        return updated;
    }

    public CaseRecord addNote(String id, String author, String message) {
        CaseRecord record = getCaseById(id);
        record.getNotes().add(CaseNote.builder()
                .author(author)
                .message(message)
                .createdAt(Instant.now())
                .build());
        record.setUpdatedAt(Instant.now());
        CaseRecord updated = caseRepository.save(record);
        auditService.log(id, "NOTE_ADDED", author);
        return updated;
    }
}