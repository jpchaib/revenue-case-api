package au.nsw.revenue.caseapi.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import au.nsw.revenue.caseapi.model.CaseRecord;
import au.nsw.revenue.caseapi.service.CaseService;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CaseController {

    private final CaseService caseService;

    @GetMapping
    public List<CaseRecord> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/{id}")
    public CaseRecord getCaseById(@PathVariable String id) {
        return caseService.getCaseById(id);
    }

    @PostMapping
    public CaseRecord createCase(@RequestBody CaseRecord record) {
        return caseService.createCase(record);
    }

    @PatchMapping("/{id}/status")
    public CaseRecord updateStatus(@PathVariable String id, @RequestBody UpdateStatusRequest request) {
        return caseService.updateStatus(id, request.getStatus(), request.getActor());
    }

    @PostMapping("/{id}/notes")
    public CaseRecord addNote(@PathVariable String id, @RequestBody AddNoteRequest request) {
        return caseService.addNote(id, request.getAuthor(), request.getMessage());
    }

    @Data
    public static class UpdateStatusRequest {
        private String status;
        private String actor;
    }

    @Data
    public static class AddNoteRequest {
        private String author;
        private String message;
    }
}