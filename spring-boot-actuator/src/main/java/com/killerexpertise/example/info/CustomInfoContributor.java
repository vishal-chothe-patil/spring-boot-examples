package com.killerexpertise.example.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {

    //  Programmatic InfoContributor (to guarantee info is shown)
    //  Create a class CustomInfoContributor.java

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", Map.of(
                "name", "Spring Boot Actuator Example",
                "description", "Demo app with multiple actuator endpoints",
                "version", "1.0.0"
        )).withDetail("developer", Map.of(
                "name", "Vishal Chothe",
                "email", "vishalchothe134@gmail.com"
        ));
    }
}
