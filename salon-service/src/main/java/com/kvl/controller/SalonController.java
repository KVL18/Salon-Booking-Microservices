package com.kvl.controller;


import com.kvl.mapper.SalonMapper;
import com.kvl.model.Salon;
import com.kvl.payload.dto.SalonDTO;
import com.kvl.payload.dto.UserDTO;
import com.kvl.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/salons")
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO,userDTO);
        SalonDTO salonDTO1 = SalonMapper.maptoDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PutMapping("/{salonId}")
    public ResponseEntity<SalonDTO> updateSalon(@RequestBody SalonDTO salonDTO,
                                                @PathVariable Long salonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonDTO,userDTO,salonId);
        SalonDTO salonDTO1 = SalonMapper.maptoDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<SalonDTO>> getSalons() throws Exception {

        List<Salon>salons = salonService.getAllSalons();
        List<SalonDTO> salonDTOS = salons.stream().map((salon)->
                {
                    SalonDTO salonDTO = SalonMapper.maptoDTO(salon);
                    return salonDTO;
                }
                ).toList();

         return ResponseEntity.ok(salonDTOS);

        }

    @GetMapping("/{id}")
    public ResponseEntity<SalonDTO> getSalonById(
            @PathVariable Long id
    ) throws Exception {

        Salon salon = salonService.getSalonById(id);
        SalonDTO salonDTO = SalonMapper.maptoDTO(salon);
        return ResponseEntity.ok(salonDTO);


    }

    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(
            @RequestParam("city") String city
    ) throws Exception {

        List<Salon> salons = salonService.searchSalonByCity(city);

        List<SalonDTO> salonDTOS = salons.stream().map((salon)->
                {
                    SalonDTO salonDTO = SalonMapper.maptoDTO(salon);
                    return salonDTO;
                }
                ).toList();

        return  ResponseEntity.ok(salonDTOS);



    }
    @GetMapping("/owner")
    public ResponseEntity<SalonDTO> getSalonByOwnerId(
            @PathVariable Long ownerId
    ) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO = SalonMapper.maptoDTO(salon);
        return ResponseEntity.ok(salonDTO);


    }

}
