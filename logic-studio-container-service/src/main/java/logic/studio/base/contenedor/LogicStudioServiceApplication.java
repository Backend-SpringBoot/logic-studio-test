package logic.studio.base.contenedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "logic.studio")
@EntityScan(basePackages = {"logic.studio"})
public class LogicStudioServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(LogicStudioServiceApplication.class, args);
  }
}
