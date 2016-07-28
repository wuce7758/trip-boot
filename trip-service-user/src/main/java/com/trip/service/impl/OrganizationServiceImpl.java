package com.trip.service.impl;

import com.trip.base.BaseServiceImpl;
import com.trip.model.SysOrganization;
import com.trip.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl extends BaseServiceImpl<SysOrganization> implements OrganizationService {

    @Override
    public SysOrganization createOrganization(SysOrganization organization) {
        return super.insert(organization);
    }

    @Override
    public SysOrganization updateOrganization(SysOrganization organization) {
        return null;
    }

    @Override
    public void deleteOrganization(Long organizationId) {

    }

    @Override
    public SysOrganization findOne(Long organizationId) {
        return null;
    }

    @Override
    public List<SysOrganization> findAll() {
        return null;
    }

    @Override
    public Object findAllWithExclude(SysOrganization excludeOraganization) {
        return null;
    }

    @Override
    public void move(SysOrganization source, SysOrganization target) {

    }
}
