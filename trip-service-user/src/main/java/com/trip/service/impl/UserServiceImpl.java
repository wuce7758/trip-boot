package com.trip.service.impl;


import com.trip.base.BaseServiceImpl;
import com.trip.model.SysUser;
import com.trip.service.RoleService;
import com.trip.service.UserService;
import com.trip.utils.StringUtil;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser> implements UserService {

    @Autowired
    private RoleService roleService;

    @Override
    public SysUser findByUsername(String userName) {
        if(StringUtil.isNotBlank(userName)){
            SysUser sysUser = new SysUser();
            sysUser.setUsername(userName);
            return super.selectOne(sysUser);
        }
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        SysUser user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }

        String roleIdsStr = user.getRoleIds();
        Long[] roleIds = (Long[]) ConvertUtils.convert(roleIdsStr.split(","), Long.class);

        return roleService.findRoles(roleIds);
    }

    @Override
    public Set<String> findPermissions(String username) {
        SysUser user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }

        String roleIdsStr = user.getRoleIds();
        Long[] roleIds = (Long[])ConvertUtils.convert(roleIdsStr.split(","), Long.class);

        return roleService.findPermissions(roleIds);
    }
}
