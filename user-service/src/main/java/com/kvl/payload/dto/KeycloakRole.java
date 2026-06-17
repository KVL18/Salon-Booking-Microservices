package com.kvl.payload.dto;

import lombok.Data;
import java.util.Map;

@Data
public class KeycloakRole {

    private String id;
    private String name;
    private  String description;
    private boolean clientRole;
    private boolean composite;
    private  String containerId;
    private Map<String,Object> attributes;

}
