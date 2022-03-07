package Entity;

public class Admin {
    private static int Rid;

    public Admin(int rid) {
        Rid=rid;
    }
    public static int getRid() {
        return Rid;
    }
    public void setRid(int rid) {
        Rid = rid;
    }
}