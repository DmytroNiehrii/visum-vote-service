package com.visum.vote.converter;

import com.visum.vote.dto.OutVoteOptionDto;
import com.visum.vote.entity.VoteOptionEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VoteOptionEntityToOutVoteOptionDtoConverter implements Converter<VoteOptionEntity, OutVoteOptionDto> {

    @Override
    public OutVoteOptionDto convert(VoteOptionEntity source) {
        return OutVoteOptionDto.builder()
            .id(source.getId())
            .createdAt(source.getCreatedAt())
            .lastUpdateAt(source.getLastUpdateAt())
            .owner(source.getOwner())
            .name(source.getName())
            .description(source.getDescription())
            .build();
    }
}
