package com.visum.vote.converter;

import com.visum.vote.dto.OutVoteDto;
import com.visum.vote.entity.VoteEntity;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VoteEntityToOutVoteDtoConverter implements Converter<VoteEntity, OutVoteDto> {

    @Autowired @Lazy
    private VoteOptionEntityToOutVoteOptionDtoConverter voteOptionEntityToOutVoteOptionDtoConverter;

    @Override
    public OutVoteDto convert(VoteEntity source) {
        return OutVoteDto.builder()
            .id(source.getId())
            .code(source.getCode())
            .groupCode(source.getGroupCode())
            .createdAt(source.getCreatedAt())
            .lastUpdateAt(source.getLastUpdateAt())
            .owner(source.getOwner())
            .name(source.getName())
            .description(source.getDescription())
            .options(source.getOptions() == null ? null :
                source.getOptions().stream()
                .map(voteOptionEntity -> voteOptionEntityToOutVoteOptionDtoConverter.convert(voteOptionEntity))
                .collect(Collectors.toList())
            )
            .build();
    }
}
