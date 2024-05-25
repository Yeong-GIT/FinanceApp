package gityeong.financeProject.departments.finance.entity;

import jakarta.persistence.*;

@Entity
@Table(name="financedept")
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="task_id")
    private int taskId;

    @Column(name="task_description")
    private String taskDescription;

    @Column(name="task_complete_status")
    private String taskCompleteStatus;

    public Finance() {
    }

    public Finance(int taskId, String taskDescription, String taskCompleteStatus) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskCompleteStatus = taskCompleteStatus;
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

    public String getTaskCompleteStatus() {
        return taskCompleteStatus;
    }

    public void setTaskCompleteStatus(String taskCompleteStatus) {
        this.taskCompleteStatus = taskCompleteStatus;
    }

    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskCompleteStatus='" + taskCompleteStatus + '\'' +
                '}';
    }
}
