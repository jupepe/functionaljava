package base;

public class Worker extends Person {

    private double workingHours;
    private double hourSalary;

    public Worker() {
    }

    public Worker(String id, String name, double workingHours,
            double hourSalary) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourSalary = hourSalary;
    }

    /**
     * @return the workingHours
     */
    public double getWorkingHours() {
        return workingHours;
    }

    /**
     * @param workingHours the workingHours to set
     */
    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * @return the hourSalary
     */
    public double getHourSalary() {
        return hourSalary;
    }

    /**
     * @param hourSalary the hourSalary to set
     */
    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    @Override
    public String toString() {
        return "Worker{" + "workingHours=" + workingHours + ", hourSalary="
                + hourSalary + ", name=" + super.getName() + ", id="
                + super.getId() + "}";
    }
}
