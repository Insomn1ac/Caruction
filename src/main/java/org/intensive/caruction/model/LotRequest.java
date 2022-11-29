package org.intensive.caruction.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lot_requests")
@Data
@NoArgsConstructor
public class LotRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "created_date")
    private LocalDateTime createdDate;

    private String status;

    @PrePersist
    void createOrUpdateDate() {
        this.createdDate = LocalDateTime.now();
    }

}
