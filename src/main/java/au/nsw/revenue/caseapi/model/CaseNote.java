package au.nsw.revenue.caseapi.model;

import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseNote {
    private String author;
    private String message;
    private Instant createdAt;
}