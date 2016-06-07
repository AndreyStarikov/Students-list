package ru.andreystarikov.StudentsList;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    private String pathForSaving = "D:\\Programming\\iReport files\\TestResult2.pdf";
    private String pathForPattern = "D:\\Programming\\projects\\Students-list\\src\\main\\resources\\StudentsList.jrxml";

    public void create(ArrayList<Journal> journal) throws JRException {
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(journal);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("DATE", new Date());
        File reportPattern = new File(pathForPattern);
        JasperDesign jasperDesign = JRXmlLoader.load(reportPattern);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving);
    }
}
