package ru.andreystarikov.StudentsList;

import org.junit.Test;

import static org.junit.Assert.*;


public class JournalTest {

    @Test
    public void testGetSubject() throws Exception {

    }

    @Test
    public void testSetSubject() throws Exception {
        Journal j = new Journal();
        j.setSubject("физика");
        assertEquals("Ошибка", "физика", j.getSubject());
    }

    @Test
    public void testGetFirstName() throws Exception {

    }

    @Test
    public void testSetFirstName() throws Exception {

    }

    @Test
    public void testGetLastName() throws Exception {

    }

    @Test
    public void testSetLastName() throws Exception {

    }

    @Test
    public void testGrade1() throws Exception {
        Journal j = new Journal();
        j.setGrade(4.34);
        assertEquals("Ошибка", 4, j.getGrade());
    }

    @Test
    public void testGrade2() throws Exception {
        Journal j = new Journal();
        j.setGrade(4.67);
        assertEquals("Ошибка", 5, j.getGrade());
    }
}