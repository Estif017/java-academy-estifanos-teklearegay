package com.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    public void bookROom_should_bookSuites_whenAvailable(){
        //Arrange
        Hotel hotel = new Hotel("Test Hotel", 5, 10);

        //Act
        boolean bookingResult = hotel.bookRoom(2,true); // booking 2 suites

        //Assert
        assertTrue(bookingResult);
        assertEquals(3,hotel.getAvailableSuites()); // expecting 3
    }

    @Test
    public  void bookingRoom_shouldFail_WhenNotEnoughSuites(){
        //Arrange
        Hotel hotel = new Hotel("Test Hotel", 1, 10);

        //Act
        boolean bookingResult = hotel.bookRoom(2,true); // booking 2 suites

        //Assert
        assertTrue(bookingResult);
        assertEquals(1, hotel.getAvailableSuites()); // Should remain unchanged
    }

}