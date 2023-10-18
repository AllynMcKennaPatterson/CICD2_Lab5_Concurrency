package atu.cicd2.lab5_resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingController {

    @GetMapping("/blocking")
    public String getBlockingData() {

    }
}
