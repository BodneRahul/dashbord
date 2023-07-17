package Hotel.Manegment.demo.Paylod;

import java.util.Date;

public class ErrorDetails  {

    private Date timestamp;
    private String massage;
    private String details;

    public ErrorDetails (Date timestamp,String massage, String details){

        this.details=details;
        this.massage=massage;
        this.timestamp=timestamp;

    }

    public String getDetails() {
        return details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMassage() {
        return massage;
    }
}
