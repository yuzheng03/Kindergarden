package sg.edu.rp.c346.id21012519.kindergarden;

public class Kindergarden {
    private String enrollment;

    public Kindergarden(String enrollment, String year) {
        this.enrollment = enrollment;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Kindergarden {" +
                "enrollment='" + enrollment + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String year;
}
