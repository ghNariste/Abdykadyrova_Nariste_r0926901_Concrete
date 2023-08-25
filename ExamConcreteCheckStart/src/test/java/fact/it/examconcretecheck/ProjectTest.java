package fact.it.examconcretecheck;

import fact.it.examconcretecheck.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
    private Project project;
    private DateTimeFormatter formatter;

    @BeforeEach
    public void setUp() {
        project = new Project();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    @Test
    public void testConstructor() {
        assertNotNull(project);
    }

    @Test
    public void testSettersAndGetters() {
        project.setName("House");
        assertEquals("House", project.getName());
        project.setHeight(10);
        assertEquals(10, project.getHeight());
        project.setWidth(10);
        assertEquals(10, project.getWidth());
        project.setLength(10);
        assertEquals(10, project.getLength());
        project.setStartDate(LocalDate.parse("01/01/2020", formatter));
        assertEquals(LocalDate.parse("01/01/2020", formatter), project.getStartDate());
        project.setRenovation(true);
        assertTrue(project.isRenovation());
    }

    @Test
    public void testCalculateVolume() {
        project.setHeight(10);
        project.setWidth(10);
        project.setLength(10);
        assertEquals(1000, project.calculateVolume());
    }

    @Test
    public void testCalculateVolumeZero() {
        project.setHeight(0);
        project.setWidth(2);
        project.setLength(3);
        project.setRenovation(true);
        assertEquals(0, project.calculateVolume());
    }

    @Test
    public void testIsOverDueTrue() {
        project.setStartDate(LocalDate.parse("01/01/2018", formatter));
        assertTrue(project.isOverdue());
    }

    @Test
    public void testIsOverDueFalse() {
        project.setStartDate(LocalDate.parse("01/01/2023", formatter));
        assertFalse(project.isOverdue());
    }

    @Test
    public void testIsOverDueFalseTodayMinus1Year() {
        project.setStartDate(LocalDate.now().minusYears(1));
        assertFalse(project.isOverdue());
    }

    @Test
    public void testIsOverDueTrueTodayMinus1YearAnd1Day() {
        project.setStartDate(LocalDate.now().minusYears(1).minusDays(1));
        assertTrue(project.isOverdue());
    }

    @Test
    public void testToString() {
        project.setName("House");
        project.setHeight(10);
        project.setWidth(10);
        project.setLength(10);
        project.setRenovation(false);
        assertEquals("Project House - 1000m3", project.toString());
    }

    @Test
    public void testToStringRenovation() {
        project.setName("Apartment");
        project.setHeight(10);
        project.setWidth(20);
        project.setLength(10);
        project.setRenovation(true);
        assertEquals("Project Apartment - renovation - 2000m3", project.toString());
    }

}
