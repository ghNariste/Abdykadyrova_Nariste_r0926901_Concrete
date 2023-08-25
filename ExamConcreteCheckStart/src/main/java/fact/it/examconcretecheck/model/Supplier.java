package fact.it.examconcretecheck.model;

public class Supplier {
    private Project project;
    private String name;
    private double price;

    public Supplier(String name, double price){

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double calculateTotalPrice(){
        if (getProject().isRenovation()==true){
            return getPrice()*1.21;
        }
        else{
            return getPrice()*1.06;
        }
    }

    public String toString() {
        if (getProject().isOverdue()) {
            return "Supplier "+name+" has a project: '"+ getProject().toString();

        }
        return "Supplier "+name+" has a project: '"+ getProject().toString()+"'. This project has total price of: "+calculateTotalPrice()+" euros";
    }
}
