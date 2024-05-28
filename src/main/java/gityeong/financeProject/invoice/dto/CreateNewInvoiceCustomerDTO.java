package gityeong.financeProject.invoice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class CreateNewInvoiceCustomerDTO {

    private int customerId;
    private String description;
    private BigDecimal totalDue;
    private String taskDescription; // Task description
    private boolean taskCompleteStatus; // Task complete status

    public CreateNewInvoiceCustomerDTO() {
    }

    public CreateNewInvoiceCustomerDTO(int customerId, String description, BigDecimal totalDue, String taskDescription, boolean taskCompleteStatus) {
        this.customerId = customerId;
        this.description = description;
        this.totalDue = totalDue;
        this.taskDescription = taskDescription;
        this.taskCompleteStatus = taskCompleteStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "CreateNewInvoiceCustomerDTO{" +
                "customerId=" + customerId +
                ", description='" + description + '\'' +
                ", totalDue=" + totalDue +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskCompleteStatus=" + taskCompleteStatus +
                '}';
    }
}
