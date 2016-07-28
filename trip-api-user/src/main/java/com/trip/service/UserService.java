package com.trip.service;


import com.trip.base.BaseService;
import com.trip.model.SysUser;

import java.util.List;
import java.util.Set;

public interface UserService extends BaseService<SysUser> {

    SysUser findByUsername(String userName);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    void updateUser(SysUser user);

    void createUser(SysUser user);

    void deleteUser(Long id);

    SysUser findOne(Long id);

    void changePassword(Long id, String newPassword);

    List<SysUser> findAll();
}
