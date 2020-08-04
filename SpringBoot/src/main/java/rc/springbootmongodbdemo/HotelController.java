package rc.springbootmongodbdemo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();

        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
        // the .insert() method
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Hotel getByID(@PathVariable("id") String id){
        Hotel hotel = this.hotelRepository.findByID(id);

        return hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable int maxPrice){
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);

        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelRepository.findByCity(city);

        return hotels;
    }

    // getting a hotel by its country by following the format of the city method.
//    @GetMapping("/address/{country}")
//    public List<Hotel> getByCountry(@PathVariable("country") String country){
//        List<Hotel> hotels = this.hotelRepository.findByCountry(country);
//
//        return hotels;
//    }

    // the following two methods were made in the video and depend on the
    // class of QHotel which is autogenerated by the QuerydslPredicateExecutor
    // however since it wasnt working the class was not generated and neither of the
    // following two methods will work
//    @GetMapping("/country/{country}")
//    public List<Hotel> getByCountry(@PathVariable("country") String country){
//        // create a query class (QHotel)
//        QHotel qHotel = new QHotel("hotel");
//
//        // using the query class we can creat the filters
//        BooleanExpression filterByCountry = qHotel.address.country.eq(country);
//
//        // we can then pass the filters to the findAll() method
//        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByCountry);
//
//        return hotels;
//    }
//
//    @GetMapping("/recommended")
//    public List<Hotel> getRecommended(){
//        final int maxPrice = 100;
//        final int minRating = 7;
//
//        // create a query class (QHotel)
//        QHotel qHotel = new QHotel("hotel");
//
//        // using the query class we can create the filters
//        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
//        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);
//
//        // we can then pass the filters to the findAll() method
//        List<Hotel> hotels = this.hotelRepository.findAll(filterByPrice.and(filterByRating));
//
//        return hotels;
//    }
}