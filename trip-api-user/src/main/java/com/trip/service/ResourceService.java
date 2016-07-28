package com.trip.service;


import com.github.pagehelper.PageInfo;
import com.trip.model.SysResource;

import java.util.List;
import java.util.Set;

public interface ResourceService {

    SysResource findOne(Long id);

    Set<String> findPermissions(Set<Long> resourceIds);

    List<SysResource> findAll();

    PageInfo<SysResource> findAll(int page, int count);

    List<SysResource> findMenus(Set<String> permissions);

    void createResource(SysResource resource);

    void updateResource(SysResource resource);

    void deleteResource(Long id);
}
