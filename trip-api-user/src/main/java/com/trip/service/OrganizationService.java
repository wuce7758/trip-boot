package com.trip.service;

import com.trip.model.SysOrganization;

import java.util.List;

public interface OrganizationService {

    SysOrganization createOrganization(SysOrganization organization);

    SysOrganization updateOrganization(SysOrganization organization);

    void deleteOrganization(Long organizationId);

    SysOrganization findOne(Long organizationId);

    List<SysOrganization> findAll();

    Object findAllWithExclude(SysOrganization excludeOraganization);

    void move(SysOrganization source, SysOrganization target);

}
