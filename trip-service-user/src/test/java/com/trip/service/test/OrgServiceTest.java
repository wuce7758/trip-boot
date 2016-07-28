package com.trip.service.test;


import com.alibaba.fastjson.JSON;
import com.trip.model.SysOrganization;
import com.trip.service.OrganizationService;
import com.trip.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrgServiceTest extends BaseTest{

    @Autowired
    private OrganizationService organizationService;

    @Test
    public void testSave(){

        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setAvailable(true);
        sysOrganization.setName("test1");
        sysOrganization.setParentId(0L);
        sysOrganization.setParentIds("");

        SysOrganization temp = organizationService.createOrganization(sysOrganization);

        System.out.println(JSON.toJSONString(temp));
    }

}
