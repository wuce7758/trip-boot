package com.trip.service;


import com.trip.model.SysUser;

import java.util.Set;

public interface UserService {

    SysUser findByUsername(String userName);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

}
