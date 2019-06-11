package com.jay.ribbon;

import lombok.Data;

@Data
public class InstanceInfo {

    private String serviceId;

    private String host;

    private Integer port;
}
