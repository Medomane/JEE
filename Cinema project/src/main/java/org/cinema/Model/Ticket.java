package org.cinema.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Place place;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectionId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Projection projection;
}
