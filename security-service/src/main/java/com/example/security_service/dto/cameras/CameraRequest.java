package com.example.security_service.dto.cameras;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "ДТО для создания камеры")
@Data
public class CameraRequest {
    @Schema(description = "Название камеры", example = "Камера 1")
    @NotNull(message = "Название камеры не может быть пустым")
    private String name;
    @Schema(description = "Зона камеры", example = "Зона 1")
    @NotNull(message = "Зона камеры не может быть пустой")
    private String zone;
    @Schema(description = "Статус камеры", example = "ONLINE")
    @NotNull(message = "Статус камеры не может быть пустым")
    private String status;
    @Schema(description = "Ссылка на поток камеры" , example = "rtsp://192.168.1.100:554/user=admin&password=&channel=1&stream=0.sdp")
    private String streamUrl;
    @Schema(description = "ID периметра, к которому относится камера", example = "1")
    @NotNull(message = "ID периметра не может быть пустым")
    private Integer perimeterId;
}
