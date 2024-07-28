package logic.studio.record.request;

import lombok.Builder;

@Builder
public record InputsGrafosRequestRecord(
    String origen,
    String destino,
    Integer peso
) {

}
