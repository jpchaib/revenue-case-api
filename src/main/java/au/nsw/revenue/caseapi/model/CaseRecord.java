package au.nsw.revenue.caseapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cases")
public class CaseRecord {
    @Id
    private String id;
    private String title;
    private String customerName;
    private String type;
    private String status;
    private String priority;
    private Instant createdAt;
    private Instant updatedAt;
    @Builder.Default
    private List<CaseNote> notes = new ArrayList<>();
}