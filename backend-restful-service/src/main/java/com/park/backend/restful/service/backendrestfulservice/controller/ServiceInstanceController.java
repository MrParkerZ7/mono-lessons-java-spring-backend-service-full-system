package com.park.backend.restful.service.backendrestfulservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/server/service-instance")
public class ServiceInstanceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{appName}")
    public List<ServiceInstance> serviceInstancesByAppName(@PathVariable("appName") String appName) {
        // Return detail of App
        return this.discoveryClient.getInstances(appName);
    }
}
