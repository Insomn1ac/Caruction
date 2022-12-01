package org.intensive.caruction.service;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.dto.JwtResponse;
import org.intensive.caruction.dto.LoginRequest;
import org.intensive.caruction.model.Role;
import org.intensive.caruction.model.User;
import org.intensive.caruction.model.Wallet;
import org.intensive.caruction.repository.UserRepository;
import org.intensive.caruction.repository.WalletRepository;
import org.intensive.caruction.security.JWTUtil;
import org.intensive.caruction.security.UserDetailsImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional()
public class AuthService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (("admin").equals(user.getName())) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        Wallet wallet = new Wallet();
        wallet.setBalance(0D);
        walletRepository.save(wallet);
        user.setWalletId(wallet.getId());
        userRepository.save(user);
    }

    public JwtResponse authenticateUser(LoginRequest authBody) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authBody.getName(), authBody.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        authenticationManager.authenticate(authInputToken);
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return JwtResponse.builder()
                .token(token)
                .build();
    }
}
