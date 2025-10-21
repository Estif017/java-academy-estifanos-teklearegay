package com.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_should_fail_if_RoomIsOccupied() {
        //Arrange
        Room room = new Room();
        room.setDirty(true);
        room.setOccupied(true);

        //Act
        room.checkIn();

        // Assert
        // Assuming checkIn() should not change state if already occupied
        assertTrue(room.isOccupied(), "Room should remain occupied");
        assertTrue(room.isDirty(), "Room should remain dirty");

    }


    @Test
    public void checkIn_should_fail_ifRoomIsDirty() {
        // Arrange
        Room room = new Room();
        room.setOccupied(false);
        room.setDirty(true); // dirty room

        // Act
        room.checkIn();

        // Assert
        // Assuming checkIn() should not proceed if room is dirty
        assertFalse(room.isOccupied(), "Room should not be occupied if dirty");
        assertTrue(room.isDirty(), "Room should remain dirty");
    }

    @Test
    public void cleanroom_should_fail_ifRoomIsOccupied() {
        // Arrange
        Room room = new Room();
        room.setOccupied(true); // still occupied
        room.setDirty(true);

        // Act
        room.cleanroom();

        // Assert
        // Assuming cleanroom() should not clean if room is occupied
        assertTrue(room.isDirty(), "Room should remain dirty if occupied");
    }

}