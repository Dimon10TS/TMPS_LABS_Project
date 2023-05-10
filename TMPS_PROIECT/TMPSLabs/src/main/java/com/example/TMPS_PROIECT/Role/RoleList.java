package com.example.TMPS_PROIECT.Role;

import com.example.TMPS_PROIECT.interfaces.RoleIterator;

import javax.management.relation.Role;
import java.util.List;

public class RoleList implements RoleIterator {
    private List<Role> roles;
    private int position;

    public RoleList(List<Role> roles) {
        this.roles = roles;
        this.position = 0;
    }

    public boolean hasNext() {
        return position < roles.size();
    }

    public Role next() {
        Role role = roles.get(position);
        position++;
        return role;
    }
}
