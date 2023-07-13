import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ToDoListApp {
    public List<String> todoList;

    ToDoListApp(){
        todoList = new ArrayList<>();
    }
    public void addTask(String task){
        String filePath ="C:/Users/srava/OneDrive/Desktop/java/Rakesh_toDoLists.txt";
        File f = new File(filePath);
        addTextToFile(f, task);
    }

    public static void addTextToFile(File file, String textToAdd) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textToAdd);
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("your task has been successfully added: "+textToAdd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void displayTasks() {
        String filePath = "C:/Users/srava/OneDrive/Desktop/java/Rakesh_toDoLists.txt";
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (file.length() == 0) {
                    System.out.println("No tasks have been found. Please add tasks first.");
                } else {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                }
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeTasks(){
        if(todoList.isEmpty()){
            System.out.println("No tasks have been found to remove. Please add tasks first.");
        }
        else{
            if (todoList.isEmpty()) {
                System.out.println("No tasks have been found to remove. Please add tasks first.");
            } else {
                while(true){
                    System.out.println("Enter the task number to remove:");
                    Scanner sc = new Scanner(System.in);
                    int taskNumber = sc.nextInt();
                    if (taskNumber >= 1 && taskNumber <= todoList.size()) {
                        String removedTask = todoList.get(taskNumber - 1);
                        todoList.remove(taskNumber - 1);
                        System.out.println("Task \"" + removedTask + "\" has been removed.");
                        break;
                    } else {
                        System.out.println("Invalid task number. Please enter a valid task number.");
                    }
                }
            }
            
        }
    }

    public void removeAllTasks(){
        if(todoList.isEmpty()){
            System.out.println("No tasks have been found to remove. Please add tasks first.");
        }
        else {
            todoList.clear();
            System.out.println("All to-do list tasks have been removed");
        }
    }
}

class test{
    public static void main(String[] args){
        ToDoListApp todoList = new ToDoListApp();
        boolean appIsRunning = true;
        while(appIsRunning) {
            System.out.println("");
            System.out.println("======== To-Do List Application =========");
            System.out.println("Please select an option:");
            System.out.println("1.Add a task");
            System.out.println("2.Display tasks");
            System.out.println("3.Remove a task");
            System.out.println("4.Remove all task");
            System.out.println("5.Close application");
            Scanner sc = new Scanner(System.in);
            int userInputNumber = sc.nextInt();
            switch (userInputNumber) {
                case 1:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Please enter your task name:");
                    String userTask = sc2.nextLine();
                    todoList.addTask(userTask);
                    break;
                case 2:
                    todoList.displayTasks();
                    break;
                case 3:
                    todoList.removeTasks();
                    break;
                case 4:
                    todoList.removeAllTasks();
                    break;
                case 5:
                    appIsRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid selection.");
            }
        }
        System.out.println("Application has been closed. Thank you for using ToDoList Application.");
    }
}
