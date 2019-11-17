package inn.startXway.eatit.models;

public class ResponseModel {
    private String success;
    private String isInserted;

    ResponseModel(String success, String isInserted) {
        this.success = success;
        this.isInserted = isInserted;
    }

    public String getIsInserted() {
        return isInserted;
    }

    public String getSuccess() {
        return success;
    }
}

