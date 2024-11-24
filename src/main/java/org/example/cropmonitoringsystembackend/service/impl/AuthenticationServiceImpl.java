package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.auth.request.SignInRequest;
import org.example.cropmonitoringsystembackend.auth.request.SignUpRequest;
import org.example.cropmonitoringsystembackend.auth.response.JWTAuthResponse;
import org.example.cropmonitoringsystembackend.dao.SecurityDAO;
import org.example.cropmonitoringsystembackend.dao.UserDAO;
import org.example.cropmonitoringsystembackend.dto.impl.UserDTO;
import org.example.cropmonitoringsystembackend.entity.impl.User;
import org.example.cropmonitoringsystembackend.service.AuthenticationService;
import org.example.cropmonitoringsystembackend.service.JWTService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final SecurityDAO securityDAO;
    private final ModelMapper mapper;
    private final JWTService jwtService;
    private final UserDAO userDAO;
    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {
        // Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );
        // Fetch user details
        User user = securityDAO.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate tokens
        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.refreshToken(user);

        // Return both tokens
        return JWTAuthResponse.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public JWTAuthResponse signUp(SignUpRequest signUpRequest) {
        UserDTO userDTO = UserDTO.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        User savedUser = securityDAO.save(mapper.map(userDTO, User.class));

        // Generate tokens
        String accessToken = jwtService.generateToken(savedUser);
        String refreshToken = jwtService.refreshToken(savedUser);

        // Return both tokens
        return JWTAuthResponse.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        String userName = jwtService.extractUserName(accessToken);
//        if (!jwtService.isTokenValid(accessToken)) {
//            throw new IllegalArgumentException("Invalid refresh token");
//        }

        // Generate a new access token
        User user = userDAO.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String newAccessToken = jwtService.generateToken(user);

        // Return the new access token and the same refresh token
        return JWTAuthResponse.builder()
                .token(newAccessToken)
                .refreshToken(accessToken)
                .build();
    }
}
