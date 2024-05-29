package gityeong.backend.departments.finance.dto;

public class FinanceTaskDTO {

    private int taskId;
    private String taskDescription;
    private String taskCompleteStatus;
    private int saleId;

    public FinanceTaskDTO() {
    }

    public FinanceTaskDTO(int taskId, String taskDescription, String taskCompleteStatus, int saleId) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskCompleteStatus = taskCompleteStatus;
        this.saleId = saleId;
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

    public String getTaskCompleteStatus() {
        return taskCompleteStatus;
    }

    public void setTaskCompleteStatus(String taskCompleteStatus) {
        this.taskCompleteStatus = taskCompleteStatus;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    @Override
    public String toString() {
        return "FinanceTaskDTO{" +
                "taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskCompleteStatus='" + taskCompleteStatus + '\'' +
                ", saleId=" + saleId +
                '}';
    }
}
