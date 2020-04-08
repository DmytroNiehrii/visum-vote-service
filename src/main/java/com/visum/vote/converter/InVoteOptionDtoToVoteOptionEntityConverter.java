package com.visum.vote.converter;

import com.visum.vote.dto.InVoteOptionDto;
import com.visum.vote.entity.VoteOptionEntity;
import com.visum.vote.service.VoteService;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InVoteOptionDtoToVoteOptionEntityConverter implements Converter<InVoteOptionDto, VoteOptionEntity> {

    @Autowired @Lazy
    private VoteService voteService;

    @Override
    public VoteOptionEntity convert(InVoteOptionDto dto) {
        return VoteOptionEntity.builder()
            .createdAt(new Timestamp(System.currentTimeMillis()))
            .name(dto.getName())
            .description(dto.getDescription())
            .vote(dto.getVoteId() == null ? null : voteService.findById(dto.getVoteId()))
            .build();
    }
}
