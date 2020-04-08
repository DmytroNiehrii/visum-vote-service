package com.visum.vote.service;

import com.visum.vote.dto.InVoteOptionDto;
import com.visum.vote.entity.VoteOptionEntity;
import com.visum.vote.repository.VoteOptionEntityRepository;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteOptionService {

    @Autowired
    private VoteOptionEntityRepository voteOptionRepository;
    @Autowired
    private ConversionService conversionService;

    @Transactional
    public VoteOptionEntity save(InVoteOptionDto dto) {
        return save(conversionService.convert(dto, VoteOptionEntity.class));
    }

    @Transactional
    public VoteOptionEntity save(VoteOptionEntity entity) {
        return voteOptionRepository.save(entity);
    }
}
