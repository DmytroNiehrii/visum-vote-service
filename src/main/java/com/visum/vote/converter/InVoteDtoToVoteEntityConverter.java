package com.visum.vote.converter;

import com.visum.vote.dto.InVoteDto;
import com.visum.vote.entity.VoteEntity;
import java.sql.Timestamp;
import java.util.UUID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InVoteDtoToVoteEntityConverter implements Converter<InVoteDto, VoteEntity> {

    @Override
    public VoteEntity convert(InVoteDto source) {
        return VoteEntity.builder()
            .createdAt(new Timestamp(System.currentTimeMillis()))
            //.owner(SecurityContextHolder.getContext().getAuthentication().getName());
            .code(UUID.randomUUID())
            .name(source.getName())
            .description(source.getDescription())
            .groupCode(source.getGroupCode())
            .build();
    }
}
