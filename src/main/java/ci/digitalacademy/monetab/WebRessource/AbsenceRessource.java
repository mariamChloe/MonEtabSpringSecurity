package ci.digitalacademy.monetab.WebRessource;

import ci.digitalacademy.monetab.services.AbsenceService;
import ci.digitalacademy.monetab.services.dto.AbsenceDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/absences")
@Slf4j
@RequiredArgsConstructor
public class AbsenceRessource {
private final AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<AbsenceDTO> save(@RequestBody AbsenceDTO absenceDTO){
        log.debug("REST request to save absence {}", absenceDTO);
        AbsenceDTO absence = absenceService.saveAbsence(absenceDTO);
        return new ResponseEntity<>(absence, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public AbsenceDTO update(@RequestBody AbsenceDTO absenceDTO,@PathVariable Long id ){
        log.debug("REST request to update absence {} {}" , absenceDTO, id);
        return absenceService.update(absenceDTO, id);
    }

    public List<AbsenceDTO> getALL(){
        return null;
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> getOne(@PathVariable Long id){
        log.debug("REST request to get one {}", id);
        Optional<AbsenceDTO> absenceDTO = absenceService.findOne(id);
        if (absenceDTO.isPresent()){
            return new ResponseEntity<>(absenceDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Absence not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public List<AbsenceDTO> getAll(){
        log.debug("REST request to get all");
        return absenceService.findAll();
    }
    @PatchMapping("/{id}")
    public AbsenceDTO partialUpdate(@RequestBody AbsenceDTO absenceDTO, @PathVariable Long id){
        log.debug("REST request to partial update {} {}", absenceDTO, id);
        return absenceService.partialUpdate(absenceDTO, id);
    }
    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getOneBySlug(@PathVariable String slug){
        log.debug("REST request to get one by slug {}", slug);
        return null;
    }
}
