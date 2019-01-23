package com.freightsol.freightsol.service.core;

import com.freightsol.freightsol.model.auth.UserAccount;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by probal on 11/22/17.
 */
@Service
public class ReportGeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGeneratorService.class);

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;

    public void generatePdfReport(List<UserAccount> users) throws JRException{
        JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(users);
        JRPdfExporter exporter = new JRPdfExporter();
        InputStream employeeReportStream
                = getClass().getResourceAsStream("/employeeReport.jrxml");
        JasperReport jasperReport
                = JasperCompileManager.compileReport(employeeReportStream);
        JRSaver.saveObject(jasperReport, "employeeReport.jasper");
        JasperPrint jasperPrint
                = JasperFillManager.fillReport(jasperReport, null, data);

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput("employeeReport.pdf"));

        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("probal");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
    }

    public void compileReport(String reportFileName) {
        try {
            InputStream reportStream = getClass().getResourceAsStream("/".concat(reportFileName));
            jasperReport = JasperCompileManager.compileReport(reportStream);
            JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
        } catch (JRException ex) {
            LOGGER.error("");
        }
    }

    public void fillReport(Map<String,Object> parameters, List<UserAccount> data) {
        try {
            JRBeanCollectionDataSource studentDS = new JRBeanCollectionDataSource(data);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, studentDS);
        } catch (Exception ex) {
            LOGGER.error("");
        }
    }
}
