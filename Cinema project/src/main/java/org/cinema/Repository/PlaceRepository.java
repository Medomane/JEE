package org.cinema.Repository;

import org.cinema.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Long> {
}
