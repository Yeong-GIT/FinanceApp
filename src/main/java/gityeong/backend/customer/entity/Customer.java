package gityeong.backend.customer.entity;

import gityeong.backend.invoice.entity.Invoice;
import jakarta.persistence.*;

import java.util.List;
import java.util.Random;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="acc_no", unique = true)
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

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;

    //define empty constructors
    public Customer() {
    }

    //define constructors
    public Customer(String first_name, String last_name, String address, String email, String phone_no) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.address = address;
        this.email = email;
        this.phoneNo = phone_no;
    }

    @PrePersist
    public void prePersist() {
        if (accNo == 0) {
            Random random = new Random();
            this.accNo = 100000 + random.nextInt(900000); // Generate a 6-digit random number
        }
    }

    public int getId() {
        return id;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", accNo=" + accNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
