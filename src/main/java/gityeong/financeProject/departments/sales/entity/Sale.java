package gityeong.financeProject.departments.sales.entity;

import jakarta.persistence.*;

@Entity
@Table(name="salesdept")
public class Sale {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name="task_id")
        private int taskId;

        @Column(name="task_description")
        private String taskDescription;

        @Column(name="task_complete_status")
        private boolean taskCompleteStatus;

    public Sale() {
    }

    public Sale(int taskId, String taskDescription, boolean taskCompleteStatus) {
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

    public boolean isTaskCompleteStatus() {
        return taskCompleteStatus;
    }

    public void setTaskCompleteStatus(boolean taskCompleteStatus) {
        this.taskCompleteStatus = taskCompleteStatus;
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
