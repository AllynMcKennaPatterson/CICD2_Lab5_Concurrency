package atu.cicd2.lab5_resttemplate;

import org.springframework.stereotype.Service;

@Service
public class BlockingService {

    public String fetchDataBlocking() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
