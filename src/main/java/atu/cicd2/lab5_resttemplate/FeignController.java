package atu.cicd2.lab5_resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class FeignController {

    private final FeignService feignService;
    public FeignController(FeignService feignService) {
        this.feignService = feignService;
    }

    @GetMapping("/feign")
    public TodoResponse getFeignData() throws Exception{

        List<CompletableFuture<TodoResponse>> futures = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            int finalI = i;
            CompletableFuture<TodoResponse> future = CompletableFuture.supplyAsync(() -> feignService.fetchData(finalI + 1));
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.get();
        ArrayList<TodoResponse> listOfTodos = feignService.getTodoData();

        for (int i = 0; i < listOfTodos.size(); i++) {
            if (listOfTodos.get(i).getId() == 196) {
                return listOfTodos.get(i);
            }
        }
        return listOfTodos.get(0);
    }
}
