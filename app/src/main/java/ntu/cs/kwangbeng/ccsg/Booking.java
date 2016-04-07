package ntu.cs.kwangbeng.ccsg;

import java.util.Date;

public class Booking {
    private String cc;
    private String type;
    private Date startDate;
    private Date endDate;

    Booking(String cc, String type, Date startDate, Date endDate){
        this.cc = cc;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCC(){
        return cc;
    }

    public String getType(){
        return type;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }



}
