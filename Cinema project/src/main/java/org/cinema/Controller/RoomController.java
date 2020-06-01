package org.cinema.Controller;

import org.cinema.Repository.RoomRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    final RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository) { this.roomRepository = roomRepository; }
}
