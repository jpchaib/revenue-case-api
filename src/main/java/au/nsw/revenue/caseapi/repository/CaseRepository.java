package au.nsw.revenue.caseapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import au.nsw.revenue.caseapi.model.CaseRecord;

public interface CaseRepository extends MongoRepository<CaseRecord, String> {
}