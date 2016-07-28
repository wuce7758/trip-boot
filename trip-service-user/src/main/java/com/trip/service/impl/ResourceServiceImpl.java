package com.trip.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trip.base.BaseServiceImpl;
import com.trip.model.SysResource;
import com.trip.model.SysRole;
import com.trip.service.ResourceService;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<SysResource> implements ResourceService {

    @Override
    public SysResource findOne(Long id) {
        if (null != id) {
            return super.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for (Long resourceId : resourceIds) {
            SysResource resource = findOne(resourceId);
            if (resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<SysResource> findAll() {
        return super.selectAll();
    }

    @Override
    public PageInfo<SysResource> findAll(int page, int count) {
        PageHelper.startPage(page, count, "id");
        List<SysResource> list = super.selectAll();
        return new PageInfo<SysResource>(list);
    }

    @Override
    public List<SysResource> findMenus(Set<String> permissions) {
        List<SysResource> allResources = findAll();
        List<SysResource> menus = new ArrayList<SysResource>();
        for (SysResource resource : allResources) {
            if (resource.isRootNode()) {
                continue;
            }

            // 如果不是菜单
            if (!resource.getType().equals(SysResource.ResourceType.menu.toString())) {
                continue;
            }

            if (!hasPermission(permissions, resource)) {
                continue;
            }

            menus.add(resource);
        }
        return menus;
    }

    @Override
    public void createResource(SysResource resource) {
        super.save(resource);
    }

    @Override
    public void updateResource(SysResource resource) {
        super.updateNotNull(resource);
    }

    @Override
    public void deleteResource(Long id) {
        super.delete(id);
    }

    private boolean hasPermission(Set<String> permissions, SysResource resource) {
        if (StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for (String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if (p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

}
