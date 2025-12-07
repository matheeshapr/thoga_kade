package model.dto;

import lombok.Data;

@Data
public class SuppliyDTO {

    private String id;
    private String name;
    private String comname;
    private String address;
    private String city;
    private String province;
    private String postcode;
    private String phno;
    private String email;

    public SuppliyDTO(String id, String name, String comname, String address, String city, String province, String postcode, String phno, String email) {
        this.id = id;
        this.name = name;
        this.comname = comname;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postcode = postcode;
        this.phno = phno;
        this.email = email;
    }

    public String getSupid() {
        return id;
    }

    public String getSupname() {
        return name;
    }

    public String getComname() {
        return comname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhno() {
        return phno;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SuppliyDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", comname='" + comname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phno='" + phno + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
