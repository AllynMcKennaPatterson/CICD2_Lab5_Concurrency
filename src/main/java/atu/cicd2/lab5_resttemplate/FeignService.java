package atu.cicd2.lab5_resttemplate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeignService {

    private final TodoClient todoClient;
    ArrayList<TodoResponse> todoData = new ArrayList<>();

    public FeignService(TodoClient todoClient){
        this.todoClient = todoClient;
    }

    public ArrayList<TodoResponse> getTodoData() {
        return todoData;
    }

    public TodoResponse fetchData(int i) {
        TodoResponse td = todoClient.fetchData(i);
        todoData.add(td);
        return td;
    }
}
