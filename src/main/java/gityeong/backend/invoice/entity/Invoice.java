package gityeong.backend.invoice.entity;

import gityeong.backend.customer.entity.Customer;
import gityeong.backend.departments.sales.entity.Sale;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="inv_no")
    private int invNo;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="description")
    private String description;

    @Column(name="total_due")
    private BigDecimal totalDue;

    @Column(name="inv_approval_status")
    private boolean invApprovalStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "invoice")
    private Sale task;

    //define empty constructor

    public Invoice() {
    }

    public Invoice(int id, int invNo, Date createdDate, String description, BigDecimal totalDue, boolean invApprovalStatus, Customer customer, Sale task) {
        this.id = id;
        this.invNo = invNo;
        this.createdDate = createdDate;
        this.description = description;
        this.totalDue = totalDue;
        this.invApprovalStatus = invApprovalStatus;
        this.customer = customer;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Sale getTask() {
        return task;
    }

    public void setTask(Sale task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invNo=" + invNo +
                ", createdDate=" + createdDate +
                ", description='" + description + '\'' +
                ", totalDue=" + totalDue +
                ", invApprovalStatus=" + invApprovalStatus +
                ", customer=" + customer +
                ", task=" + task +
                '}';
    }
}
