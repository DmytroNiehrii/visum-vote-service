package com.visum.vote.converter;

import com.visum.vote.dto.InVoteDto;
import com.visum.vote.entity.VoteEntity;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InVoteDtoToVoteEntityConverter implements Converter<InVoteDto, VoteEntity> {

    //@Autowired @Lazy
    //private InVoteOptionDtoToVoteOptionEntityConverter inVoteOptionDtoToVoteOptionEntityConverter;

    @Override
    public VoteEntity convert(InVoteDto source) {
        return VoteEntity.builder()
            .createdAt(new Timestamp(System.currentTimeMillis()))
            //.owner(SecurityContextHolder.getContext().getAuthentication().getName());
            .code(UUID.randomUUID())
            .name(source.getName())
            .description(source.getDescription())
            .groupCode(source.getGroupCode())
            /*.options(
                source.getOptions().stream()
                .map(inVoteOptionDto -> inVoteOptionDtoToVoteOptionEntityConverter.convert(inVoteOptionDto))
                .collect(Collectors.toList())
            )*/
            .build();
    }
}
