package com.trip.service;


import com.trip.model.SysResource;

import java.util.List;
import java.util.Set;

public interface ResourceService {

    SysResource findOne(Long id);

    Set<String> findPermissions(Set<Long> resourceIds);

    List<SysResource> findAll();

    List<SysResource> findMenus(Set<String> permissions);
}