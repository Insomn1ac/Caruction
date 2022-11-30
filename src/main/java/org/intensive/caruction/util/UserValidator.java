package org.intensive.caruction.util;

import lombok.RequiredArgsConstructor;
import org.intensive.caruction.model.User;
import org.intensive.caruction.service.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        try {
            userDetailsService.loadUserByUsername(user.getName());
        } catch (UsernameNotFoundException ignore) {
            return;
        }

        errors.rejectValue("username", "", "User ---");
    }
}
