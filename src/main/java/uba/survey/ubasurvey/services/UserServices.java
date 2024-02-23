package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uba.survey.ubasurvey.DTO.AuthenticationResponse;
import uba.survey.ubasurvey.DTO.CreateUserReq;
import uba.survey.ubasurvey.DTO.LoginRequest;
import uba.survey.ubasurvey.entity.User;
import uba.survey.ubasurvey.entity.UserRole;
import uba.survey.ubasurvey.repository.UserRepo;
import uba.survey.ubasurvey.security.JWTTokenProvider;


@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepo userRepo;
    private final JWTTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public String createUser(CreateUserReq createUserReq){
        User user = new User();
        user.setUserName(createUserReq.getUserName());
        user.setRole(UserRole.ROLE_ADMIN_ASSIST);
        user.setPassword(passwordEncoder.encode(createUserReq.getPassword()));
        user.setEmail(createUserReq.getEmail());
        userRepo.save(user);
        return "User Created";
    }

    public AuthenticationResponse authenticate(LoginRequest loginRequest) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
        User user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not found"));

        SecurityContextHolder.getContext().setAuthentication(auth);
        return AuthenticationResponse.builder()
                .token(jwtTokenProvider
                        .generateToken(auth, false))
                .role(user.getRole().name())
                .build();
    }

    public AuthenticationResponse appCreate(CreateUserReq createUserReq) {
        User user = new User();
        user.setUserName(createUserReq.getUserName());
        user.setRole(UserRole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(createUserReq.getPassword()));
        user.setEmail(createUserReq.getEmail());
        userRepo.save(user);
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getEmail(), createUserReq.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);
        return AuthenticationResponse.builder()
                .token(jwtTokenProvider
                        .generateToken(auth, true))
                .role(user.getRole().name())
                .build();
    }

    public AuthenticationResponse appAuthenticate(LoginRequest loginRequest) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
        User user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not found"));

        SecurityContextHolder.getContext().setAuthentication(auth);
        return AuthenticationResponse.builder()
                .token(jwtTokenProvider
                        .generateToken(auth, true))
                .role(user.getRole().name())
                .build();
    }
}
