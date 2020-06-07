package org.backend;

import org.backend.Model.*;
import org.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication

public class App implements CommandLineRunner {
    /*@Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    ProjectionRepository projectionRepository;
    @Autowired
    TicketRepository ticketRepository;*/

    final RepositoryRestConfiguration repositoryRestConfiguration;

    public App(RepositoryRestConfiguration repositoryRestConfiguration) {
        this.repositoryRestConfiguration = repositoryRestConfiguration;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Film.class);
        /*List<Cinema> cinemaList = cinemaRepository.findAll();
        cinemaList.forEach(cinema->{
            int max = (int)Math.round((Math.random()*2));
            for(int i=1;i<=max;i++){
                Room room = new Room();
                room.setCinema(cinema);
                room.setName("Room "+i);
                roomRepository.save(room);
                int tmax = (int)Math.round((Math.random()*7)+1);
                for (int j = 1; j <= tmax; j++) {
                    Place place = new Place();
                    place.setAltitude(0);
                    place.setLatitude(0);
                    place.setLongitude(0);
                    place.setNumber(j);
                    place.setRoom(room);
                    placeRepository.save(place);
                }
            }
        });



        List<Film> filmList = filmRepository.findAll();
        List<Session> sessionList = sessionRepository.findAll();
        final int[] paymentCode = {0};
        filmList.forEach(film ->{
            //7
            List<Room> roomList = roomRepository.findAllById(getNRandom( (int)Math.round((Math.random()*5)),34  ));
            roomList.forEach(room->{
                //5
                sessionList.forEach(session->{
                    //7
                    Projection projection = new Projection();
                    projection.setDate(randomHireday());
                    projection.setFilm(film);
                    projection.setRoom(room);
                    projection.setSession(session);
                    projectionRepository.save(projection);
                    List<Place> placeList = placeRepository.findAll();
                    placeList.forEach(place->{
                        //169
                        paymentCode[0]++;
                        Ticket ticket = new Ticket();
                        ticket.setClientName("");
                        ticket.setReserved(false);
                        ticket.setPaymentCode(paymentCode[0]);
                        ticket.setPlace(place);
                        ticket.setPrice(Math.round((Math.random()*100)+30));
                        ticket.setProjection(projection);
                        ticketRepository.save(ticket);
                        System.out.println(ticket.getId());
                    });
                });
            });
        });







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
    /*public static List<Long> getNRandom(int n, int max) {
        List<Long> set = new ArrayList<>();
        while(set.size() <=n) set.add(Math.round((Math.random()*max))+1);
        return set;
    }
    public static Date randomHireday() {
        int startYear=2018;									//Starting year of specified random date
        int endYear=2021;									//Starting year of specified random date (including)
        long start = Timestamp.valueOf(startYear+1+"-1-1 0:0:0").getTime();
        long end = Timestamp.valueOf(endYear+"-1-1 0:0:0").getTime();
        long ms=(long) ((end-start)*Math.random()+start);	//The qualified number of 13-bit milliseconds is obtained.
        Date hireday=new Date(ms);
        return hireday;
    }*/
}