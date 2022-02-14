package net.dreamstack.kafir2;

import net.dreamstack.kafir2.kafka.Kafir2Binding;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = {Kafir2Binding.class})
@SpringBootApplication
public class Kafir2Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Kafir2Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");
    }
}
