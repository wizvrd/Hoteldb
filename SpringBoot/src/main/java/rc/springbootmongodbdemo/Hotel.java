package rc.springbootmongodbdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document (collection = "hotels") //
public class Hotel {
    @Id
    private String ID;
    private String name;

    @Indexed (direction = IndexDirection.ASCENDING) // when hotel entities are stored in a mongodb collection the
    private int pricePerNight;                          // pricepernight property will be indexed in ascending order.

    private Address address;
    private List<Review> reviews;

    protected Hotel() {
        this.reviews = new ArrayList<>();
    }

    public Hotel( String name, int pricePerNight, Address address, List<Review> reviews) {
        this.pricePerNight = pricePerNight;
        this.name = name;
        this.address = address;
        this.reviews = reviews;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public Address getAddress() {
        return address;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
