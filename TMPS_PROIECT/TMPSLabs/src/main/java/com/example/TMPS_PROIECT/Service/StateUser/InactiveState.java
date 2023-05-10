package com.example.TMPS_PROIECT.Service.StateUser;

import com.example.TMPS_PROIECT.interfaces.UserRoleState;

public class InactiveState implements UserRoleState {
    public void performAction() {
        System.out.println("Performing actions for inactive role");
    }
}