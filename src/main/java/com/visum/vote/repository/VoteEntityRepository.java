package com.visum.vote.repository;

import com.visum.vote.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteEntityRepository extends JpaRepository<VoteEntity, Long> {
}
