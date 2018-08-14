package domain;

public class User {

    private String userName;
    private String birthDay;
    private String mobPhon;
    private String city;

    public User(String userName, String birthDay, String mobPhon, String city) {
        this.userName = userName;
        this.birthDay = birthDay;
        this.mobPhon = mobPhon;
        this.city = city;
    }

    public User(String birthDay) {
        this.birthDay = birthDay;
    }

    public User(String userName, String birthDay) {
        this.userName = userName;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", mobPhon='" + mobPhon + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
