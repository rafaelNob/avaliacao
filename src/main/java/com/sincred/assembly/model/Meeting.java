package com.sincred.assembly.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode()
@ToString
public class Meeting implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;


    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<AssociatedVote> associatedVotes;

    @PrePersist
    public void createdDate(){
        this.createdDate = LocalDateTime.now();
    }
}
