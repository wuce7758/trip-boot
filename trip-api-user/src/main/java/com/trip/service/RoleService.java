package com.trip.service;


import com.github.pagehelper.PageInfo;
import com.trip.model.SysRole;

import java.util.List;
import java.util.Set;

public interface RoleService {

    SysRole findOne(Long id);

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);

    List<SysRole> findAll();

    PageInfo<SysRole> findAll(int page, int count);

    void createRole(SysRole role);

    void updateRole(SysRole role);

    void deleteRole(Long id);
}
