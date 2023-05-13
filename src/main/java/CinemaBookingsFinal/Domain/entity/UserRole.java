package CinemaBookingsFinal.Domain.entity;

import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
public enum UserRole {
    CUSTOMER("CLIENT"),
    ADMIN("ADMIN");

    private String value;

    public static UserRole fromValue(String userRole){
        return Arrays.asList(UserRole.values())
                .stream().filter(r -> r.value.equals(userRole))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException(String
                        .format("Role %s not found",userRole)));
    }

    public String getValue() {
        return value;
    }
}