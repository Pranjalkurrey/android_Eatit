package inn.startXway.eatit.models;

public class User
{
    private String uname;

    private String phone;

    public User(String uname, String phone) {
        this.uname = uname;
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public String getPhone() {
        return phone;
    }

}
