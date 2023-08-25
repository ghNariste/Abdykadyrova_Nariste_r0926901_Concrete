package fact.it.examconcretecheck;
import fact.it.examconcretecheck.model.Supplier;
import fact.it.examconcretecheck.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
public class SupplierTest {
    private Project project;
    private Supplier supplier;
    private DateTimeFormatter formatter;

    @BeforeEach
    public void setUp() {
        project = new Project();
        supplier = new Supplier("Concrete house", 100);
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Test
    public void testConstructor() {
        assertNotNull(supplier);
        assertEquals("Concrete house", supplier.getName());
        assertEquals(100, supplier.getPrice());
    }
    @Test
    public void testSettersAndGetters() {
        supplier.setName("Concrete house");
        assertEquals("Concrete house", supplier.getName());
        supplier.setPrice(110);
        assertEquals(110, supplier.getPrice());
        Project project = new Project();
        supplier.setProject(project);
        assertEquals(project, supplier.getProject());
    }

    @Test
    public void testCalculateTotalPriceWithZero() {
        Project project = new Project();
        project.setHeight(10);
        project.setWidth(0);
        project.setLength(10);
        project.setRenovation(false);
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        supplier.setProject(project);
        assertEquals(0, supplier.calculateTotalPrice());
    }


    @Test
    public void testCalculateTotalPriceNewProject() {
        Project project = new Project();
        project.setHeight(10);
        project.setWidth(10);
        project.setLength(10);
        project.setRenovation(false);
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        supplier.setProject(project);
        assertEquals(121000, supplier.calculateTotalPrice());
    }


    @Test
    public void testCalculateTotalPriceRenovation() {
        project.setHeight(10);
        project.setWidth(10);
        project.setLength(10);
        project.setRenovation(true);
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        supplier.setProject(project);
        assertEquals(106000, supplier.calculateTotalPrice());
    }

    @Test
    public void testCalculateTotalPriceRenovationWithZero() {
        project.setHeight(10);
        project.setWidth(0);
        project.setLength(10);
        project.setRenovation(true);
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        supplier.setProject(project);
        assertEquals(0, supplier.calculateTotalPrice());
    }

    @Test
    public void testToStringRenovation() {
        supplier.setName("Concrete house");
        project.setName("House");
        project.setHeight(5);
        project.setWidth(5);
        project.setLength(5);
        project.setRenovation(true);
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        supplier.setProject(project);
        assertEquals("Supplier Concrete house has a project: 'Project House - renovation - 125m3'. This project has a total price of: 13250.0 euros.", supplier.toString());
    }

    @Test
    public void testToStringNewProject() {
        supplier.setName("AVL");
        project.setName("Familyhome");
        project.setHeight(5);
        project.setWidth(5);
        project.setLength(5);
        project.setRenovation(false);
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        supplier.setProject(project);
        assertEquals("Supplier AVL has a project: 'Project Familyhome - 125m3'. This project has a total price of: 15125.0 euros.", supplier.toString());
    }

    @Test
    public void testToStringOverdue() {
        supplier.setName("CC-supplier");
        project.setName("Apartment");
        project.setHeight(5);
        project.setWidth(2);
        project.setLength(9);
        project.setRenovation(false);
        project.setStartDate(LocalDate.parse("01/01/2020", formatter));
        supplier.setProject(project);
        assertEquals("Supplier CC-supplier has a project: 'Project Apartment - 90m3'. This project is overdue.", supplier.toString());
    }

}
