package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.RapportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class RapportServiceImpl implements RapportService {

    private final UserRepository userRepository;

    public RapportServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ByteArrayInputStream generatePdfReport(String type) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add content to the PDF
            document.add(new Paragraph("Rapport " + type));

            // Fetch data from the database
            List<User> users = fetchUsers(type);
            for (User user : users) {
                document.add(new Paragraph(user.getId() + " - " + user.getPseudo()));
            }

            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException("Failed to generate PDF report", e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public ByteArrayInputStream generateExcelReport(String type) {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Report");

            // Add headers
            Row header = sheet.createRow(0);
            switch (type) {
                case "students":
                    header.createCell(0).setCellValue("Student ID");
                    header.createCell(1).setCellValue("Student Name");
                    break;
                case "teachers":
                    header.createCell(0).setCellValue("Teacher ID");
                    header.createCell(1).setCellValue("Teacher Name");
                    break;
                case "users":
                    header.createCell(0).setCellValue("User ID");
                    header.createCell(1).setCellValue("User Name");
                    break;
                default:
                    header.createCell(0).setCellValue("ID");
                    header.createCell(1).setCellValue("Name");
            }

            // Fetch data from the database
            List<User> users = fetchUsers(type);
            int rowIdx = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getPseudo());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate Excel report", e);
        }
    }

    private List<User> fetchUsers(String type) {
        // Implement data fetching logic here based on the type
        switch (type) {

            case "users":
                return userRepository.findAll();
            default:
                return List.of();
        }
    }
}