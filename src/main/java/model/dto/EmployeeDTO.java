package model.dto;

public class EmployeeDTO {
    private String id;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private String salary;
    private String conno;
    private String address;
    private String join;
    private String status;

    public EmployeeDTO(String id, String name, String nic, String dob, String position, String salary, String conno, String address, String join, String status) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.dob = dob;
        this.position = position;
        this.salary = salary;
        this.conno = conno;
        this.address = address;
        this.join = join;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }

    public String getDob() {
        return dob;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public String getConno() {
        return conno;
    }

    public String getAddress() {
        return address;
    }

    public String getJoin() {
        return join;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setConno(String conno) {
        this.conno = conno;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", dob='" + dob + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", conno='" + conno + '\'' +
                ", address='" + address + '\'' +
                ", join='" + join + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}