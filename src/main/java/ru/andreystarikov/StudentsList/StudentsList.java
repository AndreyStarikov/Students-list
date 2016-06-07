package ru.andreystarikov.StudentsList;

import java.util.ArrayList;

import static ru.andreystarikov.StudentsList.DBConnector.connectToDB;

public class StudentsList {

    private static final String SQLCOMMAND = "select subjects.subject AS Предмет, students.last_name AS Фамилия, students.first_name AS Имя, avg(grades.grade) AS Оценка from grades inner join students on grades.student_id = students.id inner join subjects on grades.subject_id = subjects.id group by subject_id, student_id ORDER BY subjects.subject, students.last_name, students.first_name;";

    public static void main(String[] args) {
        ArrayList<Journal> journal;
        journal = connectToDB(SQLCOMMAND);
        System.out.println("Начало генерации отчёта");
        try {
            new ReportGenerator().create(journal);
            System.out.println("Генерация отчёта завершена");
        } catch (Exception e) {
            System.out.println("Во время генерации возникла ошибка: " + e);
        }


    }
}
