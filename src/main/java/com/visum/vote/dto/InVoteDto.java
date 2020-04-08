package com.visum.vote.dto;

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
public class InVoteDto {

    private String name;
    private String description;
    private UUID groupCode;
    private List<InVoteOptionDto> options;
}
