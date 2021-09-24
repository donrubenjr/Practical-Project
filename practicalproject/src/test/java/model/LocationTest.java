package model;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void getLocationId() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        assertEquals(1, location.getLocationId());
    }

    @Test
    void getCountryName() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        assertEquals("Philippines", location.getCountryName());
    }

    @Test
    void getRegionName() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        assertEquals("NCR", location.getRegionName());
    }

    @Test
    void getCityName() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        assertEquals("Quezon City", location.getCityName());
    }

    @Test
    void getLatitude() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        assertEquals(-90.0000001, location.getLatitude());
    }

    @Test
    void getLongitude() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        assertEquals(90.0000001, location.getLongitude());
    }

    @Test
    void setCountryName() {
        Location location = new Location(1,"Philippines", "NCR", "Quezon City",
                -90.0000001, 90.0000001);
        location.setCountryName("UAE");
        assertEquals("UAE", location.getCountryName());
    }

}