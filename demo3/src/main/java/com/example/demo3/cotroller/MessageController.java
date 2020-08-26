package com.example.demo3.cotroller;

import com.example.demo3.service.SQSService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final SQSService service;

    public MessageController(SQSService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessage(@RequestBody String message){
        System.out.println("message is "+ message);
        service.sendMessage(message);

        return "SUCCESS";
    }
}
