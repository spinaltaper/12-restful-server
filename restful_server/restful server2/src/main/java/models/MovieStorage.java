package models;

import java.util.HashMap;
import java.util.Map;

public class MovieStorage {
    public static Map<Integer, Movie> movies;
    static{
        movies = new HashMap<>();
        Movie ANewHope = new Movie("A New Hope",121);
        Movie TaxiDriver = new Movie("Taxi Driver",113);

        movies.put(ANewHope.id,ANewHope);
        movies.put(TaxiDriver.id,TaxiDriver);
    }
}
