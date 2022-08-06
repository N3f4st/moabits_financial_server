package com.orion.financial_mss.controller;

import com.orion.financial_mss.model.AppUser;
import com.orion.financial_mss.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app-user")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("save")
    public ResponseEntity<String> saveAppUser() {
        AppUser appUser = new AppUser("jurg", "juerguen herrera", "12334");
        appUserService.saveAppUser(appUser);
        return ResponseEntity.ok().body("created");
    }
}
