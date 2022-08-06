package com.orion.financial_mss.interfaces;

import com.orion.financial_mss.model.AppUser;

public interface AppUserInterface {
    AppUser saveAppUser(AppUser appUser);
    AppUser getAppUserByUserName(String userName);
}
