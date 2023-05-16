package CinemaBookingsFinal.Service.impl;

import CinemaBookingsFinal.Domain.dto.User.UserDTO;
import CinemaBookingsFinal.Domain.dto.User.UserUpdateDTO;
import CinemaBookingsFinal.Domain.entity.User;
import CinemaBookingsFinal.Domain.entity.UserRole;
import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import CinemaBookingsFinal.Domain.mapper.UserMapper;
import CinemaBookingsFinal.Repository.UserRepository;
import CinemaBookingsFinal.Service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("User with id %s not found",id)));

    }

    @Override
    public UserDTO registerUser(UserDTO req, String userRole) {
        User u = UserMapper.toEntity(req);
        u.setRole(userRole!=null? UserRole.fromValue(userRole):UserRole.CUSTOMER);
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u = userRepository.save(u);
        return UserMapper.toDto(u);
    }

    @Override
    public UserUpdateDTO updateUser(Integer id, UserUpdateDTO req) {
        User u = getUserById(id);
        u = UserMapper.buildUpdateUser(u,req);
        return UserMapper.toUpdateDto(userRepository.save(u));
    }

    @Override
    public User getUserFromToken(Jwt jwt) {
        String sub = (String) jwt.getClaims().get("sub");
        return userRepository.findByEmail(sub).get();
    }
}
