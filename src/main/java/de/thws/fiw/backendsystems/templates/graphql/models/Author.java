package de.thws.fiw.backendsystems.templates.graphql.models;

public class Author extends AbstractModel {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
