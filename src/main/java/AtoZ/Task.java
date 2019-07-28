package main.java.AtoZ;

public class Task {
    String taskName;
    Integer skillRequired;
    Integer timeTaken;

    Task(String taskName, int timeTaken, int skillRequired) {
        this.taskName = taskName;
        this.timeTaken = timeTaken;
        this.skillRequired = skillRequired;
    }

    String getTaskName() {
        return taskName;
    }

    void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(Integer skillRequired) {
        this.skillRequired = skillRequired;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }
}
