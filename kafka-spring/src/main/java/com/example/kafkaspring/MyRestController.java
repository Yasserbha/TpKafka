package com.example.kafkaspring;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;


import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;


//envoi du msg
@RestController
@EnableKafka
public class MyRestController {


    @Autowired
    private KafkaTemplate<String,Reunion> kafkaTemplate;


  /*  @GetMapping("send/{message}/{topic}")
    public String send(@PathVariable String message, @PathVariable String topic){
    kafkaTemplate.send(topic,"key"+message.length(),message);
    return message;
    }*/
      @GetMapping("send/{reunionName}/{topic}")
    public String send(@PathVariable String reunionName, @PathVariable String topic){
          Reunion reunion = new Reunion(reunionName,new Date(),new Random().nextInt(100));
    kafkaTemplate.send(topic,"key"+reunion.getName(),reunion);
    return "send reunion";
    }

}
