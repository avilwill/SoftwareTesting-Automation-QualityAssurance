// File: src/test/appointmentServiceTest.java
package Test;

import Main.Appointment;
import Main.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

//    get instance of appointment service and appointment for testing
    private AppointmentService service;
    private Appointment appt;

//    get a future date for testing
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

//    set up before each test
    @BeforeEach
    void setUp() {
        service = new AppointmentService();
        appt = new Appointment("apt_1", getFutureDate(), "Test description");
    }

//    test adding appointment successfully
    @Test
    void testAddAppointmentSuccess() {
        service.addAppointment(appt);
        assertEquals(appt, service.getAppointment("apt_1"));
    }

//    test adding duplicate appointment id
    @Test
    void testAddDuplicateAppointmentID() {
        service.addAppointment(appt);
        Appointment appt2 = new Appointment("apt_1", getFutureDate(), "Another desc");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appt2));
        assertTrue(ex.getMessage().contains("unique"));
    }

//    test deleting appointment successfully
    @Test
    void testDeleteAppointmentSuccess() {
        service.addAppointment(appt);
        service.deleteAppointment("apt_1");
        assertNull(service.getAppointment("apt_1"));
    }

//    test deleting nonexistent appointment
    @Test
    void testDeleteNonexistentAppointment() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("apt_2"));
        assertTrue(ex.getMessage().contains("not found"));
    }

//    test getting appointment successfully
    @Test
    void testGetAppointmentReturnsNullIfNotFound() {
        assertNull(service.getAppointment("apt_3"));
    }
}
