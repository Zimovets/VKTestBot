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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getMobPhon() {
        return mobPhon;
    }

    public void setMobPhon(String mobPhon) {
        this.mobPhon = mobPhon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
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
