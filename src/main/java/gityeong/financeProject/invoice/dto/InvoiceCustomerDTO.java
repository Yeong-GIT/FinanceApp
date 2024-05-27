package gityeong.financeProject.invoice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.math.BigDecimal;

public class InvoiceCustomerDTO {
    private int invoiceId;
    private int invNo;
    private Date createdDate;
    private String description;
    private BigDecimal totalDue;
    private boolean invApprovalStatus;
    private int customerId;
    private int accNo;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNo;

    public InvoiceCustomerDTO(int invoiceId, int invNo, Date createdDate, String description, BigDecimal totalDue, boolean invApprovalStatus, int customerId, int accNo, String firstName, String lastName, String address, String email, String phoneNo) {
        this.invoiceId = invoiceId;
        this.invNo = invNo;
        this.createdDate = createdDate;
        this.description = description;
        this.totalDue = totalDue;
        this.invApprovalStatus = invApprovalStatus;
        this.customerId = customerId;
        this.accNo = accNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInvNo() {
        return invNo;
    }

    public void setInvNo(int invNo) {
        this.invNo = invNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public boolean isInvApprovalStatus() {
        return invApprovalStatus;
    }

    public void setInvApprovalStatus(boolean invApprovalStatus) {
        this.invApprovalStatus = invApprovalStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "InvoiceCustomerDTO{" +
                "invoiceId=" + invoiceId +
                ", invNo=" + invNo +
                ", createdDate=" + createdDate +
                ", description='" + description + '\'' +
                ", totalDue=" + totalDue +
                ", invApprovalStatus=" + invApprovalStatus +
                ", customerId=" + customerId +
                ", accNo=" + accNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
