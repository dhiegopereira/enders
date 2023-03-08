package main.java.com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.example.demo.model.Enders;

@RestController
public class EndersController {

   private final RestTemplate restTemplate = new RestTemplate();
   private final ObjectMapper objectMapper = new ObjectMapper();

   @GetMapping("/enders/{cep}")
   public ResponseEntity<Enders> getEnders(@PathVariable String cep) throws Exception {
      String url = "https://viacep.com.br/ws/62040744/json/";
      String json = restTemplate.getForObject(url, String.class);
      Enders enders = objectMapper.readValue(json, Enders.class);
      return ResponseEntity.ok(enders);
   }
}
