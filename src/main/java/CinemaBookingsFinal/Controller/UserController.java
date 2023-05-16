package CinemaBookingsFinal.Controller;

import CinemaBookingsFinal.Domain.dto.User.UserDTO;
import CinemaBookingsFinal.Domain.dto.User.UserUpdateDTO;
import CinemaBookingsFinal.Domain.entity.User;
import CinemaBookingsFinal.Domain.mapper.UserMapper;
import CinemaBookingsFinal.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{userRole}")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO req, @PathVariable String userRole){
        UserDTO dto = userService.registerUser(req,userRole);
        return ResponseEntity.ok(dto);
    }

    @RolesAllowed("ADMIN")
    @PutMapping("/admin/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable Integer id, @RequestBody UserUpdateDTO req){
        UserUpdateDTO u = userService.updateUser(id,req);
        return ResponseEntity.ok(u);
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable Integer id){
        User u = userService.getUserById(id);
        return ResponseEntity.ok(UserMapper.toDto(u));
    }
}
