package gityeong.backend.invoice.dto;

import java.math.BigDecimal;

public class UpdateInvoiceDTO {

    private String description;
    private BigDecimal totalDue;
    private String taskDescription; // Task description
    private boolean taskCompleteStatus; // Task complete status

    public UpdateInvoiceDTO() {
    }

    public UpdateInvoiceDTO(String description, BigDecimal totalDue, String taskDescription, boolean taskCompleteStatus) {
        this.description = description;
        this.totalDue = totalDue;
        this.taskDescription = taskDescription;
        this.taskCompleteStatus = taskCompleteStatus;
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
        return "UpdateInvoiceDTO{" +
                "description='" + description + '\'' +
                ", totalDue=" + totalDue +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskCompleteStatus=" + taskCompleteStatus +
                '}';
    }
}
