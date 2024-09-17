package ci.digitalacademy.monetab.WebRessource;

import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRessource {

    private final UserService userService;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @Operation(summary = "Create user", description = "This endpoint allows to create a user")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        log.debug("Rest Request to save User : {}", userDTO);
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @Operation(summary = "Get all users", description = "This endpoint allows to retrieve all users")
    public ResponseEntity<List<UserDTO>> findAll() {
        log.debug("Rest Request to get all Users");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @Operation(summary = "Get user by ID", description = "This endpoint allows to retrieve a user by ID")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        log.debug("Rest Request to get User by ID : {}", id);
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @Operation(summary = "Get user by slug", description = "This endpoint allows to retrieve a user by slug")
    public ResponseEntity<UserDTO> findBySlug(@PathVariable String slug) {
        log.debug("Rest Request to get User by slug : {}", slug);
        return new ResponseEntity<>(userService.findBySlug(slug), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @Operation(summary = "Update user", description = "This endpoint allows to update a user")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        log.debug("Rest Request to update User : {}", userDTO);
        return new ResponseEntity<>(userService.update(id, userDTO), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "User partially updated successfully")
    @Operation(summary = "Partially update user", description = "This endpoint allows to partially update a user")
    public ResponseEntity<UserDTO> partialUpdate(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        log.debug("Rest Request to partially update User : {}", userDTO);
        return new ResponseEntity<>(userService.partialUpdate(id, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @Operation(summary = "Delete user", description = "This endpoint allows to delete a user")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("Rest Request to delete User by ID : {}", id);
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
