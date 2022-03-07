package Entity;

public class ManagerMess {
    int id;
    String password;
    String gender;
    String tele;
    String qqMobile;

    public ManagerMess() {
    }

    public ManagerMess(int id, String password, String gender, String tele, String qqMobile) {
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.tele = tele;
        this.qqMobile = qqMobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getQqMobile() {
        return qqMobile;
    }

    public void setQqMobile(String qqMobile) {
        this.qqMobile = qqMobile;
    }
}
