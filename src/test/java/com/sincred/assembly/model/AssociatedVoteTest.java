package com.sincred.assembly.model;

public class AssociatedVoteTest {

    public static AssociatedVote associatedVote(){
        return AssociatedVote.builder()
                .id(1L)
                .meeting(Meeting.builder().build())
                .cpf("338.046.328-07")
                .vote(Boolean.TRUE)
                .build();
    }
}
