package com.sincred.assembly.repository;

import com.sincred.assembly.model.AssociatedVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociatedVoteRepository extends JpaRepository<AssociatedVote, Long> {
    Boolean existsByCpf(String cpf);
}
