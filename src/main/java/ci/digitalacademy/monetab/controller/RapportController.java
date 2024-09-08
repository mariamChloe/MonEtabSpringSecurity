package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.RapportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Controller
@RequestMapping("/Rapport")
@RequiredArgsConstructor
public class RapportController {

    private final RapportService rapportService;

    @GetMapping
    public String showRapport() {
        return "/Rapport/rapport";
    }

    @GetMapping("/generatePdf")
    public ResponseEntity<ByteArrayResource> generatePdfReport(@RequestParam("type") String type) {
        try {
            ByteArrayInputStream bis = rapportService.generatePdfReport(type);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
            ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/generateExcel")
    public ResponseEntity<ByteArrayResource> generateExcelReport(@RequestParam("type") String type) {
        try {
            ByteArrayInputStream bis = rapportService.generateExcelReport(type);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.xlsx");
            ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}