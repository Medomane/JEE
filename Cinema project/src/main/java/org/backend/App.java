package org.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*List<Long> t = new ArrayList<>();
        t.add(1L);
        t.add(2L);
        t.add(3L);
        t.add(4L);
        roomRepository.findAllById(t).forEach(room -> {
            for(int i=1;i<=9;i++){
                Place place = new Place();
                place.setNumber(i);
                place.setLongitude(0);
                place.setLatitude(0);
                place.setAltitude(0);
                place.setRoom(room);
                placeRepository.save(place);
            }
        });
        List<Long> t = new ArrayList<>();
        t.add(1L);
        t.add(9L);
        t.add(13L);
        t.add(16L);
        t.add(20L);
        t.add(24L);
        final int[] a = {0};
        projectionRepository.findAll().forEach(projection->{
            placeRepository.findAll().forEach(place->{
                Ticket ticket = new Ticket();
                ticket.setClientName("");
                ticket.setPrice(Math.round((Math.random()*100)+30));
                ticket.setPaymentCode(a[0]);//ThreadLocalRandom.current().nextInt(0, 1000 + 1));
                ticket.setReserved(false);
                ticket.setPlace(place);
                ticket.setProjection(projection);
                ticketRepository.save(ticket);
                a[0]++;
            });
        });*/
    }
}