package fact.it.examconcretecheck.model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Project {
    private String name;

    private int height;
    private int width;
    private int length;
    private LocalDate startDate;
    private boolean renovation;

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isRenovation() {
        return renovation;
    }

    public void setRenovation(boolean renovation) {
        this.renovation = renovation;
    }
    public int calculateVolume(){
       return height*width*length;
    }
    public boolean isOverdue(){
        int year1 = getStartDate().getYear()-1;
//        int day = getStartDate().getMonthValue();
//        int month = getStartDate().getDayOfMonth();
//        LocalDate year = LocalDate.of(year1, month, day);
        LocalDate year2= LocalDate.now().minusYears(1);
        long countYear = ChronoUnit.YEARS.between(getStartDate(), LocalDate.now());
        if (countYear > 1){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public String toString(){
        if (!renovation && !isOverdue()){
            return "Project"+name+" - "+calculateVolume()+"m3"+"This project is overdue";

        }
        else{
            return "Project "+name+" - "+"renovation"+" - "+calculateVolume()+"m3";

        }
    }
}
