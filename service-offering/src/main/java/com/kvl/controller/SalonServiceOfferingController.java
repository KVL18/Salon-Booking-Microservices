package com.kvl.controller;


import com.kvl.dto.CategoryDTO;
import com.kvl.dto.SalonDTO;
import com.kvl.dto.ServiceDTO;
import com.kvl.model.ServiceOffering;
import com.kvl.service.ServiceOfferingService;
import com.kvl.service.client.CategoryFeignClient;
import com.kvl.service.client.SalonFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private  final ServiceOfferingService serviceOfferingService;
    private final SalonFeignClient salonFeignClient;
    private final CategoryFeignClient categoryFeignClient;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO,
            @RequestHeader("Authorization") String jwt
            ) throws Exception {
        SalonDTO salonDTO = salonFeignClient.getSalonByOwnerId(jwt).getBody();
        System.out.println("salonDTO.getId() = " + salonDTO.getId());
        System.out.println("serviceDTO.getCategory() = " + serviceDTO.getCategory());
        CategoryDTO categoryDTO =
                categoryFeignClient.getCategoriesByIdAndSalon(
                        serviceDTO.getCategory(), // 352
                        salonDTO.getId()          // 2
                ).getBody();

        ServiceOffering serviceOfferings = serviceOfferingService.createService(
                salonDTO,
                serviceDTO,categoryDTO);

        return ResponseEntity.ok(serviceOfferings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
    ) throws Exception {

        ServiceOffering serviceOfferings = serviceOfferingService.updateService(
                id,serviceOffering);

        return ResponseEntity.ok(serviceOfferings);
    }


}
