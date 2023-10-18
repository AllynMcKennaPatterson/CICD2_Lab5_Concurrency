package atu.cicd2.lab5_resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class FeignController {

    public FeignController() {

    }

    @GetMapping("/feign")
    public String getFeignData() throws Exception, InterruptedException {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<TodoResponse>> futures = new ArrayList<>();


        long endTime = System.currentTimeMillis();

        return "Total execution time: " + (endTime - startTime) + " ms";
    }
}
