package Test;
import Main.Appointment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

class AppointmentTest {

//    get a future date for testing
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

//    test valid appointment creation
    @Test
    void testValidAppointmentCreation() {
        Appointment appt = new Appointment("apt_1", getFutureDate(), "Valid description");
        assertEquals("apt_1", appt.getAppointmentID());
        assertEquals("Valid description", appt.getDescription());
        assertNotNull(appt.getAppointmentDate());
    }

//    test invalid appointment creation scenarios
    @Test
    void testNullAppointmentID() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Appointment(null, getFutureDate(), "desc"));
        assertTrue(ex.getMessage().contains("Appointment ID"));
    }

//    test appointment id longer than 10 characters
    @Test
    void testLongAppointmentID() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Appointment("12345678910", getFutureDate(), "desc"));
        assertTrue(ex.getMessage().contains("Appointment ID"));
    }


    //    test null appointment date
    @Test
    void testNullAppointmentDate() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Appointment("apt_1", null, "desc"));
        assertTrue(ex.getMessage().contains("Appointment date"));
    }

//test appointment date in the past
    @Test
    void testPastAppointmentDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date pastDate = cal.getTime();
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Appointment("apt_1", pastDate, "desc"));
        assertTrue(ex.getMessage().contains("Appointment date"));
    }
//test null description
    @Test
    void testNullDescription() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Appointment("apt_1", getFutureDate(), null));
        assertTrue(ex.getMessage().contains("Description"));
    }

//    test description longer than 50 characters
    @Test
    void testLongDescription() {
        String longDesc = "a".repeat(51);
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                new Appointment("apt_1", getFutureDate(), longDesc));
        assertTrue(ex.getMessage().contains("Description"));
    }


//test setters for appointment date and description
    @Test
    void testSetValidAppointmentDate() {
        Appointment appt = new Appointment("apt_1", getFutureDate(), "desc");
        Date newDate = getFutureDate();
        appt.setAppointmentDate(newDate);
        assertEquals(newDate, appt.getAppointmentDate());
    }

    @Test
    void testSetInvalidAppointmentDate() {
        Appointment appt = new Appointment("apt_1", getFutureDate(), "desc");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            appt.setAppointmentDate(cal.getTime());
        });
        assertTrue(ex.getMessage().contains("Appointment date"));
    }

//    test setting valid and invalid description
    @Test
    void testSetValidDescription() {
        Appointment appt = new Appointment("apt_1", getFutureDate(), "desc");
        appt.setDescription("New description");
        assertEquals("New description", appt.getDescription());
    }

    @Test
    void testSetInvalidDescription() {
        Appointment appt = new Appointment("apt_1", getFutureDate(), "desc");
        String longDesc = "b".repeat(51);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> appt.setDescription(longDesc));
        assertTrue(ex.getMessage().contains("Description"));
    }
}
