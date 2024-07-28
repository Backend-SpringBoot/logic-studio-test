package logic.studio.domain.application.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import logic.studio.domain.application.ports.input.logic_studio.command.TestLogicStudioCommandService;
import logic.studio.record.request.Arista;
import logic.studio.record.request.InputsGrafosRequestRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestLogicStudioCommandServiceImpl implements TestLogicStudioCommandService {

  private final Map<String, List<Arista>> listaAdyacencia = new HashMap<>();

  @Override
  public void addGrafos(List<InputsGrafosRequestRecord> inputsGrafosRequestRecords) {
    inputsGrafosRequestRecords.forEach(
        input -> agregarArista(input.origen(), input.destino(), input.peso()));
  }
  public void agregarArista(String origen, String destino, Integer peso) {
    listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, peso));
    System.out.println("Arista agregada: " + origen + " -> " + destino + " con peso " + peso);
  }
}
