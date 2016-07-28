package com.trip.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trip.base.BaseServiceImpl;
import com.trip.model.SysUser;
import com.trip.service.RoleService;
import com.trip.service.UserService;
import com.trip.utils.StringUtil;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser> implements UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordHelper passwordHelper;

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

    @Override
    public void updateUser(SysUser user) {
        super.updateNotNull(user);
    }

    @Override
    public void createUser(SysUser user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        super.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        super.delete(id);
    }

    @Override
    public SysUser findOne(Long id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        SysUser user = this.findOne(id);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        super.updateNotNull(user);
    }

    @Override
    public List<SysUser> findAll() {
        return super.selectAll();
    }

    @Override
    public PageInfo<SysUser> findAll(int page, int count) {
        PageHelper.startPage(page, count, "id");
        List<SysUser> list = super.selectAll();
        return new PageInfo<SysUser>(list);
    }
}
