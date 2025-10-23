package model.dto;

public class CustomerDTO {
    private String custid;
    private String custtitle;
    private String custname;
    private String custdob;
    private String custsalary;
    private String custaddress;
    private String custcity;
    private String custprovince;
    private String custpostalcode;

    public CustomerDTO(String custid, String custtitle, String custname, String custdob, String custsalary, String custaddress, String custcity, String custprovince, String custpostalcode) {
        this.custid = custid;
        this.custtitle = custtitle;
        this.custname = custname;
        this.custdob = custdob;
        this.custsalary = custsalary;
        this.custaddress = custaddress;
        this.custcity = custcity;
        this.custprovince = custprovince;
        this.custpostalcode = custpostalcode;
    }

    public String getCustid() {
        return custid;
    }

    public String getCusttitle() {
        return custtitle;
    }

    public String getCustname() {
        return custname;
    }

    public String getCustdob() {
        return custdob;
    }

    public String getCustsalary() {
        return custsalary;
    }

    public String getCustaddress() {
        return custaddress;
    }

    public String getCustcity() {
        return custcity;
    }

    public String getCustprovince() {
        return custprovince;
    }

    public String getCustpostalcode() {
        return custpostalcode;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public void setCusttitle(String custtitle) {
        this.custtitle = custtitle;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public void setCustdob(String custdob) {
        this.custdob = custdob;
    }

    public void setCustsalary(String custsalary) {
        this.custsalary = custsalary;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public void setCustprovince(String custprovince) {
        this.custprovince = custprovince;
    }

    public void setCustpostalcode(String custpostalcode) {
        this.custpostalcode = custpostalcode;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "custid='" + custid + '\'' +
                ", custtitle='" + custtitle + '\'' +
                ", custname='" + custname + '\'' +
                ", custdob='" + custdob + '\'' +
                ", custsalary='" + custsalary + '\'' +
                ", custaddress='" + custaddress + '\'' +
                ", custcity='" + custcity + '\'' +
                ", custprovince='" + custprovince + '\'' +
                ", custpostalcode='" + custpostalcode + '\'' +
                '}';
    }
}
