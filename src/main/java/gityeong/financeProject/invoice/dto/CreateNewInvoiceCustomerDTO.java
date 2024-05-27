package gityeong.financeProject.invoice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CreateNewInvoiceCustomerDTO {

    private int customerId;
    private BigInteger accNo;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNo;
    private String description;
    private BigDecimal totalDue;

    public CreateNewInvoiceCustomerDTO() {
    }

    public CreateNewInvoiceCustomerDTO(int customerId, BigInteger accNo, String firstName, String lastName, String address, String email, String phoneNo, String description, BigDecimal totalDue) {
        this.customerId = customerId;
        this.accNo = accNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
        this.description = description;
        this.totalDue = totalDue;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigInteger getAccNo() {
        return accNo;
    }

    public void setAccNo(BigInteger accNo) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    @Override
    public String toString() {
        return "CreateNewInvoiceCustomerDTO{" +
                "customerId=" + customerId +
                ", accNo=" + accNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", description='" + description + '\'' +
                ", totalDue=" + totalDue +
                '}';
    }
}
