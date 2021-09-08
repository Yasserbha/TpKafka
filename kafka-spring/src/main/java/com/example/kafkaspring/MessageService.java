package com.example.kafkaspring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
// recive message
//le controller send message
@Service
public class MessageService {

    // pour consume Object Reunion on ajouter la methode de deserialisation 
    @KafkaListener(topics = "test1",groupId = "groupe-ms")
    public void onMessage(ConsumerRecord<String ,String> message) throws JsonProcessingException {

        Reunion reunion = reunionToJson(message.value());
        System.out.println("**********************");
        System.out.println(message.key()+"=>"+reunion.toString());
    }
    private Reunion reunionToJson(String json) throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        Reunion reunion =jsonMapper.readValue(json,Reunion.class);
    return  reunion;
    }



}
