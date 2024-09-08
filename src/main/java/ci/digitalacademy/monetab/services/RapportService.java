package ci.digitalacademy.monetab.services;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public interface RapportService {
    ByteArrayInputStream generatePdfReport(String type);
    ByteArrayInputStream generateExcelReport(String type);
}

