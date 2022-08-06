package com.orion.financial_mss.service;

import com.orion.financial_mss.interfaces.AppUserInterface;
import com.orion.financial_mss.model.AppUser;
import com.orion.financial_mss.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserService implements AppUserInterface, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("The userName does not exist");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(appUser.getUserName(), appUser.getPassword(), authorities);
    }

    @Override
    public AppUser getAppUserByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) throws ResponseStatusException {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        if (appUserRepository.findByUserName(appUser.getUserName()) != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The User Name already exist");

        return appUserRepository.save(appUser);
    }

}
