package main.java.AtoZ;

public class Employee {
    String employeeName;
    Integer hourRemaining;
    Integer skillLevel;

    Employee(String name, int hours, int level) {
        this.employeeName = name;
        this.hourRemaining = hours;
        this.skillLevel = level;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getHourRemaining() {
        return hourRemaining;
    }

    public void setHourRemaining(Integer hourRemaining) {
        this.hourRemaining = hourRemaining;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }
}
