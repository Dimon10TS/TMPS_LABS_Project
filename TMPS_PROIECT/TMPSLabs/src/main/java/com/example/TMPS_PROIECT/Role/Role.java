package com.example.TMPS_PROIECT.Role;

import com.example.TMPS_PROIECT.Service.StateUser.ActiveState;
import com.example.TMPS_PROIECT.interfaces.UserRoleState;

public class Role {
    private String name;
    private UserRoleState state;

    public Role(String name) {
        this.name = name;
        this.state = new ActiveState(); // Starea implicită este activă
    }

    public void setState(UserRoleState state) {
        this.state = state;
    }

    public void performAction() {
        state.performAction();
    }

    // Getters and setters
}
