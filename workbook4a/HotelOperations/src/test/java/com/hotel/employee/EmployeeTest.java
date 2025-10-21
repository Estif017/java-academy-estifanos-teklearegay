package com.hotel.employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @org.junit.jupiter.api.Test
    void getTotalPay() {
    }

    public void punchOut_should_addWorkedHours_toEmployee() {
        // Arrange
        Employee employee = new Employee("E001", "Estifanos", "Front Desk", 20.0, 0.0);
        double timeIn = 9.0;   // 9:00 AM
        double timeOut = 17.0; // 5:00 PM

        // Act
        employee.punchTimeCard(timeIn, timeOut);

        // Assert
        assertEquals(8.0, employee.getHoursWorked(), 0.01, "Employee should have 8 hours worked after punching out");
    }


}