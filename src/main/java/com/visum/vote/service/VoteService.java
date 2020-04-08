package com.visum.vote.service;

import com.visum.vote.dto.InVoteDto;
import com.visum.vote.dto.OutVoteDto;
import com.visum.vote.entity.VoteEntity;
import com.visum.vote.entity.VoteOptionEntity;
import com.visum.vote.repository.VoteEntityRepository;
import com.visum.vote.repository.VoteOptionEntityRepository;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class VoteService {

    @Autowired
    private VoteEntityRepository voteRepository;
    @Autowired
    private VoteOptionEntityRepository voteOptionEntityRepository;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private VoteOptionService voteOptionService;
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public VoteEntity save(InVoteDto dto) {
        final VoteEntity voteEntity = voteRepository.save(conversionService.convert(dto, VoteEntity.class));
        // Save all vote's options as well
        dto.getOptions().stream()
            .forEach(inVoteOptionDto -> {
                inVoteOptionDto.setVoteId(null);
                VoteOptionEntity voteOptionEntity = conversionService.convert(inVoteOptionDto, VoteOptionEntity.class);
                voteOptionEntity.setVote(voteEntity);
                voteOptionService.save(voteOptionEntity);
            });
        entityManager.refresh(voteEntity);
        return voteEntity;
    }

    public Page<VoteEntity> findAll(Pageable pageable) {
        return voteRepository.findAll(pageable);
    }

    public VoteEntity findById(Long id) {
        Optional<VoteEntity> entity = voteRepository.findById(id);
        if (!entity.isPresent()) {
            throw new EntityNotFoundException(String.format("No vote with id = %s", id));
        }
        return entity.get();
    }
}
