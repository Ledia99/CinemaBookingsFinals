package CinemaBookingsFinal.Service;

import CinemaBookingsFinal.Domain.dto.User.UserDTO;
import CinemaBookingsFinal.Domain.dto.User.UserUpdateDTO;
import CinemaBookingsFinal.Domain.entity.*;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> getAllUsers();

    User getUserById(Integer id);

    UserDTO registerUser(UserDTO req, String userRole);

    UserUpdateDTO updateUser(Integer id,UserUpdateDTO req);

    User getUserFromToken(Jwt jwt);

}
