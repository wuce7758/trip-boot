package com.trip.service.impl;

import com.trip.base.BaseServiceImpl;
import com.trip.model.SysRole;
import com.trip.service.ResourceService;
import com.trip.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return null;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            SysRole role = findOne(roleId);
            if(role != null) {
                String[] resourceids = role.getResourceIds().split(",");
                resourceIds.addAll(string2List(resourceids));
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

    private List<Long> string2List(String[] arr){
        List<Long> list = new ArrayList<>(arr.length);
        for(String str : arr){
            list.add(Long.valueOf(str));
        }
        return list;
    }

}
