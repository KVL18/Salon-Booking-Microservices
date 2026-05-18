package com.kvl.mapper;

import com.kvl.model.Salon;
import com.kvl.payload.dto.SalonDTO;

public class SalonMapper {

    public static SalonDTO maptoDTO(Salon salon){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(salon.getId());
        salonDTO.setCity(salon.getCity());
        salonDTO.setPhoneNumber(salon.getPhoneNumber());
        salonDTO.setName(salon.getName());
        salonDTO.setAddress(salon.getAddress());
        salonDTO.setEmail(salon.getEmail());
        salonDTO.setImages(salon.getImages());
        salonDTO.setCloseTime(salon.getCloseTime());
        salonDTO.setOpenTime(salon.getOpenTime());
        salonDTO.setOwnerId(salon.getOwnerId());

        return  salonDTO;
    }
}
