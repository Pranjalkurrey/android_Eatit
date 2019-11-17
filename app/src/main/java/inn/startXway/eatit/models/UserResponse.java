package inn.startXway.eatit.models;

public class UserResponse {
    private String name;
    private String phone;
    private String success;
    private String mealName;
    private String mealPrice;
    private String mealDescr;
    private String mealImage;
    private String mealStatus;
    private String mealRating;
    private String mealId;




    public UserResponse(String name, String phone, String success, String mealName, String mealPrice, String mealDescr, String mealImage, String mealStatus, String mealRating, String mealId) {
        this.name = name;
        this.phone = phone;
        this.success = success;
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.mealDescr = mealDescr;
        this.mealImage = mealImage;
        this.mealStatus = mealStatus;
        this.mealRating = mealRating;
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSuccess() {
        return success;
    }

    public String getMealRating() {
        return mealRating;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public String getMealDescr() {
        return mealDescr;
    }

    public String getMealImage() {
        return mealImage;
    }

    public String getMealStatus() {
        return mealStatus;
    }

    public String getMealId() {
        return mealId;
    }
}
