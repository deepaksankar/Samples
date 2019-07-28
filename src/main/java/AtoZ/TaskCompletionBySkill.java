package main.java.AtoZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TaskCompletionBySkill {

    public static void main(String[] args) {
        Employee e1 = new Employee("Sam", 4, 5);
        Employee e2 = new Employee("Teresa", 6, 4);
        Employee e3 = new Employee("David", 5, 3);
        Employee e4 = new Employee("Martha", 7, 3);
        Employee e5 = new Employee("Will", 4, 5);

        List<Employee> employeeList = new LinkedList<>();
        TaskCompletionBySkill tsk = new TaskCompletionBySkill();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        Task task1 = new Task("Shipping", 5, 4);
        Task task2 = new Task("Ordering", 7, 2);
        Task task3 = new Task("Logistics", 3, 3);

        List<Task> taskList = new LinkedList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        Comparator<Employee> empCompareBySkill = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSkillLevel().compareTo(o2.getSkillLevel());
            }
        };

        Comparator<Task> taskCompareBySkill = Comparator.comparing(Task::getSkillRequired);
        taskList.sort(taskCompareBySkill.reversed());
        employeeList.sort(empCompareBySkill.reversed());
        System.out.println("Done");
        int empIndex = -1;
        Set<String> resultEmployees = new LinkedHashSet<>();

        while(!taskList.isEmpty()) {
            Task priorityTask = taskList.remove(0);

            if(employeeList.get(1).getSkillLevel() < priorityTask.getSkillRequired()) {
                empIndex = 0;
            }
            if (empIndex == -1) {
                for(int i = 1; i < employeeList.size()-1; i++) {
                    if(employeeList.get(i+1).getSkillLevel() < priorityTask.getSkillRequired()) {
                        empIndex = i;
                        break;
                    }
                }
            }

            if(empIndex == -1 && !taskList.isEmpty()) {
                System.out.println("Cannot complete all tasks");
            }
            for(int empNo = empIndex; empNo < employeeList.size(); empNo++) {
                Employee currentEmp = employeeList.get(empNo);
                int employeeTime = currentEmp.getHourRemaining();
                int taskTime = priorityTask.getTimeTaken();
                if(employeeTime - taskTime == 0) {
                    currentEmp.setHourRemaining(0);
                    priorityTask.setTimeTaken(0);
                    resultEmployees.add(currentEmp.getEmployeeName());
                    break;
                } else if (employeeTime - taskTime < 0) {
                    currentEmp.setHourRemaining(0);
                    priorityTask.setTimeTaken(taskTime-employeeTime);
                    resultEmployees.add(currentEmp.getEmployeeName());
                    continue;
                } else {
                    priorityTask.setTimeTaken(0);
                    currentEmp.setHourRemaining(employeeTime - taskTime);
                    resultEmployees.add(currentEmp.getEmployeeName());
                    break;
                }
            }
        }

        List<String> results = new ArrayList<>(resultEmployees);
        System.out.println("Lets see if it works!!" + results);
    }
}
