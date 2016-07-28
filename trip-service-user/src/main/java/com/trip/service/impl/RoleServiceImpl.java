package com.trip.service.impl;

import com.trip.base.BaseServiceImpl;
import com.trip.model.SysRole;
import com.trip.service.ResourceService;
import com.trip.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl extends BaseServiceImpl<SysRole> implements RoleService {

    @Autowired
    private ResourceService resourceService;

    @Override
    public SysRole findOne(Long id) {
        if(null != id){
            return super.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            SysRole role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            SysRole role = findOne(roleId);
            if(role != null) {
                String[] ids = role.getResourceIds().split(",");
                resourceIds.addAll(string2List(ids));
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

    @Override
    public List<SysRole> findAll() {
        return super.selectAll();
    }

    @Override
    public void createRole(SysRole role) {
        super.save(role);
    }

    @Override
    public void updateRole(SysRole role) {
        super.updateNotNull(role);
    }

    @Override
    public void deleteRole(Long id) {
        super.delete(id);
    }

    private List<Long> string2List(String[] arr){
        List<Long> list = new ArrayList<>(arr.length);
        for(String str : arr){
            list.add(Long.valueOf(str));
        }
        return list;
    }

}
