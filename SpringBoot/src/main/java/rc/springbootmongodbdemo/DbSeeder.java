package rc.springbootmongodbdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DbSeeder implements CommandLineRunner { // when the springbootapp starts the CommandLineRunner will automatically be executed
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel shariton = new Hotel(
                "Shariton",
                180,
                new Address("Woodbridge", "United States"),
                Arrays.asList(
                        new Review("Mason", 9, false),
                        new Review("Danny", 6, true)
                )
        );

        Hotel delta = new Hotel(
                "Delta",
                260,
                new Address("Manhattan", "United States"),
                Arrays.asList(
                        new Review("Hadia", 10, true)
                )
        );

        Hotel holidayInn = new Hotel(
                "HolidayInn",
                90,
                new Address("Iselin", "United States"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        // add our hotels to the database
        List<Hotel> hotels = Arrays.asList(shariton, delta, holidayInn);
        this.hotelRepository.saveAll(hotels);
    }
}
