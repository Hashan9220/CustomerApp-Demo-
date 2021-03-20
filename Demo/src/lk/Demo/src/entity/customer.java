package lk.Demo.src.entity;

public class customer {
    private String cutomer_id;
    private String name;
    private String contact;
    private String email;
    private String address;


    public customer() {
    }

    public customer(String cutomer_id, String name, String contact, String email, String address) {
        this.cutomer_id = cutomer_id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public String getCutomer_id() {
        return cutomer_id;
    }

    public void setCutomer_id(String cutomer_id) {
        this.cutomer_id = cutomer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
