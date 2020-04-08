package com.visum.vote.repository;

import com.visum.vote.entity.VoteOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteOptionEntityRepository extends JpaRepository<VoteOptionEntity, Long> {
}
