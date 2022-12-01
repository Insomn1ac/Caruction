package org.intensive.caruction.service;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.model.Role;
import org.intensive.caruction.model.User;
import org.intensive.caruction.model.Wallet;
import org.intensive.caruction.repository.UserRepository;
import org.intensive.caruction.repository.WalletRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional()
public class RegistrationService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final PasswordEncoder passwordEncoder;

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
}
