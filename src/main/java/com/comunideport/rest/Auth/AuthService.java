package com.comunideport.rest.Auth;

import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.User;
import com.comunideport.rest.Entities.Enum.RoleUser;
import com.comunideport.rest.Jwt.JwtService;
import com.comunideport.rest.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public AuthResponse register(RegisterRequest request) {
        // TODO Auto-generated method stub
        User user = User.builder()
            .name(request.getName())
            .id_card(request.getId_card())
            .sex(request.getSex())
            .date_birth(request.getDate_birth())
            .health_status(request.getHealth_status())
            .email(request.getEmail())
            .password(request.getPassword())
            .phone(request.getPhone())
            .address(request.getAddress())
            .city(request.getCity())
            .country(request.getCountry())
            .profile_picture_url(request.getProfile_picture_url())
            .role(RoleUser.USER)
            .date_joined(request.getDate_joined())
            .last_login(request.getLast_login())
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }

}
