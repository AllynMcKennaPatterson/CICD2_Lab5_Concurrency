package atu.cicd2.lab5_resttemplate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface TodoClient {

    @GetMapping("todos/{todoId}" )
    TodoResponse fetchData(@PathVariable("todoId") int todoId);

}
