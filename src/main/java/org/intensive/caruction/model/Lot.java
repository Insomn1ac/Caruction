package org.intensive.caruction.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lots")
@Data
@NoArgsConstructor
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String status;

    @Column(name = "start_price")
    private double startPrice;

    // TODO better to user final_price (change in liquibase required)
    @Column(name = "finish_price")
    private double finishPrice;
}
