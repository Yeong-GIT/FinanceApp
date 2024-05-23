package gityeong.financeProject.customer.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="acc_no")
    private int accNo;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="phone_no")
    private String phoneNo;

    //define empty constructors
    public Customer() {
    }

    //define constructors
    public Customer(int acc_no, String first_name, String last_name, String address, String email, String phone_no) {
        this.accNo = acc_no;
        this.firstName = first_name;
        this.lastName = last_name;
        this.address = address;
        this.email = email;
        this.phoneNo = phone_no;
    }

    //define getter and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcc_no() {
        return accNo;
    }

    public void setAcc_no(int acc_no) {
        this.accNo = acc_no;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phoneNo;
    }

    public void setPhone_no(String phone_no) {
        this.phoneNo = phone_no;
    }

    //define toString

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", acc_no=" + accNo +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone_no='" + phoneNo + '\'' +
                '}';
    }
}
