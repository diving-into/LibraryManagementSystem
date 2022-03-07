package Entity;

import java.sql.Date;

public class Details {
      int Rid;
      int Did;
      String Dname;
      String Dstatus;
      Date DborrowDate;
      Date DreturnDate;

    public Details() {
    }

    public Details(int rid, int did, String dname, String dstatus, Date dborrowDate, Date dreturnDate) {
        Rid = rid;
        Did = did;
        Dname = dname;
        Dstatus = dstatus;
        DborrowDate = dborrowDate;
        DreturnDate = dreturnDate;
    }

    public int getRid() {
        return Rid;
    }

    public void setRid(int rid) {
        Rid = rid;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDstatus() {
        return Dstatus;
    }

    public void setDstatus(String dstatus) {
        Dstatus = dstatus;
    }

    public Date getDborrowDate() {
        return DborrowDate;
    }

    public void setDborrowDate(Date dborrowDate) {
        DborrowDate = dborrowDate;
    }

    public Date getDreturnDate() {
        return DreturnDate;
    }

    public void setDreturnDate(Date dreturnDate) {
        DreturnDate = dreturnDate;
    }

    public int getDid() {
        return Did;
    }

    public void setDid(int did) {
        Did = did;
    }
}
