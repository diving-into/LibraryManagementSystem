package Entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class BookInformation {
	private int Bid;
	private String Bname;
	private String Bwriter;
	private String Bposition;
	private int  BreaderID;
	private int Bnumber;
	private String Bpublish;
	private String BinDate;
	private String Bstatus;
	private Date BborrowDate;
	private Date BreturnDate;
	
	
	public BookInformation(int bid, String bname, int bnumber, String bwriter, String bpublish, String bposition, int breaderID, String binDate, String bstatus, Date bborrowDate, Date breturnDate) {
		super();
		Bid = bid;
		Bname = bname;
		Bwriter = bwriter;
		Bposition = bposition;
		BreaderID = breaderID;
		Bnumber = bnumber;
		Bpublish = bpublish;
		BinDate = binDate;
		Bstatus = bstatus;
		BborrowDate = bborrowDate;
		BreturnDate = breturnDate;
	}

	public BookInformation(int bid, String bname, int bnumber, String bwriter, String bpublish, String bposition,String bstatus,Date borrowdate,Date breturndate,int breaderid) {

		Bid = bid;
		Bname = bname;
		Bwriter = bwriter;
		Bposition = bposition;
		Bnumber = bnumber;
		Bpublish = bpublish;
		Bstatus = bstatus;
		BborrowDate = borrowdate;
		BreturnDate = breturndate;
		BreaderID = breaderid;
	}
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBwriter() {
		return Bwriter;
	}
	public void setBwriter(String bwriter) {
		Bwriter = bwriter;
	}
	public String getBposition() {
		return Bposition;
	}
	public void setBposition(String bposition) {
		Bposition = bposition;
	}

	public int getBreaderID() {
		return BreaderID;
	}

	public void setBreaderID(int breaderID) {
		BreaderID = breaderID;
	}

	public int getBnumber() {
		return Bnumber;
	}
	public void setBnumber(int bnumber) {
		Bnumber = bnumber;
	}
	public String getBpublish() {
		return Bpublish;
	}
	public void setBpublish(String bpublish) {
		Bpublish = bpublish;
	}
	public String getBinDate() {
		return BinDate;
	}
	public void setBinDate(String binDate) {
		BinDate = binDate;
	}
	public String getBstatus() {
		return Bstatus;
	}
	public void setBstatus(String bstatus) {
		Bstatus = bstatus;
	}
	public Date getBborrowDate() {
		return BborrowDate;
	}
	public void setBborrowDate(Date bborrowDate) {
		BborrowDate = bborrowDate;
	}
	public Date getBreturnDate() {
		return BreturnDate;
	}
	public void setBreturnDate(Date breturnDate) {
		BreturnDate = breturnDate;
	}
	
}
