package com.visum.vote.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutVoteDto {

    private Long id;
    private UUID code;
    private Timestamp createdAt;
    private Timestamp lastUpdateAt;
    private String owner;
    private String name;
    private String description;
    private UUID groupCode;
    private List<OutVoteOptionDto> options;
}
