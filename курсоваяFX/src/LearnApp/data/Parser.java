package LearnApp.data;


import LearnApp.Main;
import LearnApp.objects.Student;
import LearnApp.objects.Task;
import LearnApp.objects.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Вася on 10.04.2016.
 */
public class Parser {

    private Type type;
    private Gson gson = new Gson();
    private BufferedReader br;

    public Parser(){}


    public ArrayList<Student> getStudents() throws FileNotFoundException {
        type = new TypeToken<ArrayList<Student>>(){}.getType();
        br = new BufferedReader(new FileReader("src/data/students.json"));
        return gson.fromJson(br, type);
    }
    public void updateStudents(ArrayList<Student> students) throws IOException {
        String json = gson.toJson(students);
        FileWriter writer = new FileWriter("src/data/students.json");
        writer.write(json);
        writer.close();
    }
    public void updateObservableStudents(ObservableList<Student> students) throws IOException {
        String json = gson.toJson(students);
        FileWriter writer = new FileWriter("src/data/students.json");
        writer.write(json);
        writer.close();
    }


    public Teacher getTeacher() throws FileNotFoundException {
        type = new TypeToken<Teacher>(){}.getType();
        br = new BufferedReader(new FileReader("src/data/teacher.json"));
        Teacher teacher = gson.fromJson(br, type);
        return teacher;
    }

    public void addTasks(ArrayList<Task> tasks) throws IOException {
        String json = gson.toJson(tasks);
        FileWriter writer = new FileWriter("src/data/tasks.json");
        writer.write(json);
        writer.close();
    }
    public ArrayList<Task> getTasks() throws FileNotFoundException {
        type = new TypeToken<ArrayList<Task>>(){}.getType();
        br = new BufferedReader(new FileReader("src/data/tasks.json"));
        return gson.fromJson(br,type);

    }
    public void setMark(String login, int count) throws IOException {
        ArrayList<Student> students;
        type = new TypeToken<ArrayList<Student>>(){}.getType();
        br = new BufferedReader(new FileReader("src/data/students.json"));
        students = gson.fromJson(br, type);
        for (int i=0;i<students.size();i++){
            if(students.get(i).getLogin().equals(login)){
                students.get(i).setMark(count);
                students.get(i).setPassed(true);
                System.out.println(students.get(i).getLogin());
                System.out.println(students.get(i).getMark());
            }
        }
        String json = gson.toJson(students);
        FileWriter writer = new FileWriter("src/data/students.json");
        writer.write(json);
        writer.close();
    }

    public void setMaterial(String material) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("src/data/material.txt").getAbsoluteFile());
        out.print(material);
        out.close();
    }
    public String getMaterial() throws IOException {
        StringBuilder sb = new StringBuilder();
        br = new BufferedReader(new FileReader("src/data/material.txt"));
        String s;
        while((s=br.readLine())!= null){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

}
