package gityeong.backend.departments.sales.entity;

import gityeong.backend.departments.finance.entity.Finance;
import gityeong.backend.invoice.entity.Invoice;
import jakarta.persistence.*;

@Entity
@Table(name="salesdept")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "task_id", unique = true, nullable = false)
    private int taskId;

    @Column(name="task_description")
    private String taskDescription;

    @Column(name="task_complete_status")
    private boolean taskCompleteStatus;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToOne(mappedBy = "sale")
    private Finance finance;

    public Sale() {
    }

    public Sale(int taskId, String taskDescription, boolean taskCompleteStatus) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskCompleteStatus = taskCompleteStatus;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isTaskCompleteStatus() {
        return taskCompleteStatus;
    }

    public void setTaskCompleteStatus(boolean taskCompleteStatus) {
        this.taskCompleteStatus = taskCompleteStatus;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskCompleteStatus=" + taskCompleteStatus +
                '}';
    }
}
