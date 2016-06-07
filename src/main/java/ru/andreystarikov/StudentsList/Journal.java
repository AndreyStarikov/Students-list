package ru.andreystarikov.StudentsList;

public class Journal {
    private String subject;
    private String lastName;
    private String firstName;
    private int grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public int getGrade() {
        return grade;
    }

    /**
     * Set для среднего балла. Округляет оценку в большую сторону, если дробная часть >= 0.5.
     *
     * @param grade
     */
    public void setGrade(double grade) {
        int b = (int) (grade * 10) % (((int) grade) * 10);
        if (b >= 5) {
            this.grade = 1 + (int) grade;
        } else {
            this.grade = (int) grade;
        }
    }


}
