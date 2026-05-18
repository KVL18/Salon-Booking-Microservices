package com.kvl.service;

import com.kvl.dto.CategoryDTO;
import com.kvl.dto.SalonDTO;
import com.kvl.dto.ServiceDTO;
import com.kvl.model.ServiceOffering;

import java.util.List;
import java.util.Set;

public interface ServiceOfferingService {


    ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDTO,
                                  CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId,ServiceOffering serviceOffering
                                  ) throws Exception;
    Set<ServiceOffering> getAllServiceBySalonId(Long salonId,Long categoryId);

    Set<ServiceOffering>getServicesById(Set<Long> ids);

    ServiceOffering getServiceById(Long id) throws Exception;

}
