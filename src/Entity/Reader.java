package Entity;

public class Reader {
     private static int Rid;
     private static String Rname;
     private int Rphone;
     private int Rpassword;
     
     
   public Reader(int rid, String rname, int rphone, int rpassword) {
		super();
		Rid = rid;
		Rname = rname;
		Rphone = rphone;
		Rpassword = rpassword;
	}
	public Reader (int Rid) {
		this.Rid = Rid;
	}
	public  static int getRid() {
		return Rid;
	}
	public  static void setRid(int rid) {
		Rid = rid;
	}
	public String getRname() {
		return Rname;
	}
	public void setRname(String rname) {
		Rname = rname;
	}
	public int getRphone() {
		return Rphone;
	}
	public void setRphone(int rphone) {
		Rphone = rphone;
	}
	public int getRpassword() {
		return Rpassword;
	}
	public void setRpassword(int rpassword) {
		Rpassword = rpassword;
	}
     

}
