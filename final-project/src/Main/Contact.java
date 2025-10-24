package Main;

public class Contact {
    private final String id;
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    public Contact(String id, String firstName, String lastName, String number, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

//The contact object shall have a required firstName String field that cannot be longer than 10 characters.
// The firstName field shall not be null.
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be no longer than 10 characters.");
        }
        this.firstName = firstName;
    }
//The contact object shall have a required lastName String field that cannot be longer than 10 characters.
// The lastName field shall not be null.
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be no longer than 10 characters.");
        }
        this.lastName = lastName;
    }
//The contact object shall have a required phone String field that must be exactly 10 digits.
//the phone field shall not be null.
    public String getPhone() {
        return number;
    }

    public void setPhone(String number) {
        if (number == null || !number.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number cannot be null and must be exactly 10 digits.");
        }
        this.number = number;
    }
    //The contact object shall have a required address field that must be no longer than 30 characters.
    // The address field shall not be null.
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be no longer than 30 characters.");
        }
        this.address = address;
    }
}