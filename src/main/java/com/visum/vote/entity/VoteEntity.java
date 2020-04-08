package com.visum.vote.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity(name = "Vote")
@Table(name = "vote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID code;
    private String owner;
    private Timestamp createdAt;
    private Timestamp lastUpdateAt;
    @Column(nullable = false, unique = false)
    @Length(min = 3, max = 64)
    private String name;
    @Column(nullable = true, unique = false)
    private String description;
    private UUID groupCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vote", orphanRemoval = true)
    private List<VoteOptionEntity> options;
}
