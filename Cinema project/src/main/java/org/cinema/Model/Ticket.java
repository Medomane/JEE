package org.cinema.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String clientName;
    private double price;
    @Column(unique = true)
    private int paymentCode ;
    private boolean reserved;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId",nullable = false)
    private Place place;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectionId",nullable = false)
    private Projection projection;
}
