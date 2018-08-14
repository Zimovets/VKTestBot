package domain;

public class User {

    private String firstName;
    private String secondName;
    private String birthDay;
    private String mobPhon;
    private String city;

    public User(String firstName, String secondName, String birthDay, String mobPhon, String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDay = birthDay;
        this.mobPhon = mobPhon;
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", mobPhon='" + mobPhon + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
