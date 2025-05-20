package com.killerexpertise.example.runners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.killerexpertise.example.model.Inventor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.containsOption("load-inventor")) {
            String json = args.getOptionValues("load-inventor").get(0);
            ObjectMapper mapper = new ObjectMapper();
            List<Inventor> inventors = mapper.readValue(json, new TypeReference<List<Inventor>>() {
            });
            System.out.println("Loaded Inventors:");
            inventors.forEach(System.out::println);
        } else {
            System.out.println("No --load-inventor argument provided.");
        }
    }
}

