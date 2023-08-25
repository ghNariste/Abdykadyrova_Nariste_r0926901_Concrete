package fact.it.examconcretecheck;

import fact.it.examconcretecheck.model.Project;
import fact.it.examconcretecheck.model.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static java.lang.System.exit;

@SpringBootApplication
public class ExamConcreteCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamConcreteCheckApplication.class, args);
        //Write your code here
        Project myproject = new Project();
        Supplier supplier1 = new Supplier("CementWorx", 112.5);
        myproject.setName("House Geel");
        myproject.setHeight(2);
        myproject.setLength(23);
        myproject.setWidth(15);
        myproject.isOverdue();
        myproject.setStartDate(LocalDate.of(2023, 3, 1));
        System.out.println(myproject.toString());
        System.out.println(supplier1.toString());
        exit(0);
    }

}
