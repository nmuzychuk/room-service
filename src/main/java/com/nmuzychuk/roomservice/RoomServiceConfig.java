package com.nmuzychuk.roomservice;

import com.nmuzychuk.roomcommon.RoomService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
@EntityScan("com.nmuzychuk.roomcommon")
public class RoomServiceConfig {

    final RoomService roomService;

    public RoomServiceConfig(RoomService roomService) {
        this.roomService = roomService;
    }

    @Bean
    RemoteExporter remoteExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("room-service");
        exporter.setServiceInterface(RoomService.class);
        exporter.setService(roomService);

        return exporter;
    }
}
