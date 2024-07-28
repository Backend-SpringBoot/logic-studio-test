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
        input -> addArista(input.origen(), input.destino(), input.peso()));
  }
  public void addArista(String origen, String destino, Integer peso) {
    listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, peso));
    System.out.println("Arista agregada: " + origen + " -> " + destino + " con peso " + peso);
  }

  @Override
  public void clear() {
    listaAdyacencia.clear();
    System.out.println("Todos los grafos han sido eliminados.");
  }


  private Integer obtenerPesoArista(String origen, String destino) {
    List<Arista> aristas = listaAdyacencia.get(origen);
    if (aristas != null) {
      for (Arista arista : aristas) {
        if (arista.destino().equals(destino)) {
          return arista.peso();
        }
      }
    }
    return null;
  }


  private int contarRutasDFS(String actual, String destino, int maxParadas, int paradas) {
    if (paradas > maxParadas) {
      return 0;
    }
    int conteo = 0;
    if (paradas > 0 && actual.equals(destino)) {
      conteo++;
    }
    for (Arista arista : listaAdyacencia.getOrDefault(actual, Collections.emptyList())) {
      conteo += contarRutasDFS(arista.destino(), destino, maxParadas, paradas + 1);
    }
    return conteo;
  }

  private int contarRutasExactasDFS(String actual, String destino, int paradasExactas,
      int paradas) {
    if (paradas > paradasExactas) {
      return 0;
    }
    int conteo = 0;
    if (paradas == paradasExactas && actual.equals(destino)) {
      conteo++;
    }
    for (Arista arista : listaAdyacencia.getOrDefault(actual, Collections.emptyList())) {
      conteo += contarRutasExactasDFS(arista.destino(), destino, paradasExactas, paradas + 1);
    }
    return conteo;
  }

  public Map<String, Integer> dijkstra(String inicio) {
    Map<String, Integer> distancias = new HashMap<>();
    PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(
        Comparator.comparingInt(Arista::peso));
    colaPrioridad.add(new Arista(inicio, 0));

    while (!colaPrioridad.isEmpty()) {
      Arista actual = colaPrioridad.poll();
      String nodo = actual.destino();
      int distancia = actual.peso();

      if (distancias.containsKey(nodo)) {
        continue;
      }

      distancias.put(nodo, distancia);

      for (Arista vecino : listaAdyacencia.getOrDefault(nodo, Collections.emptyList())) {
        if (!distancias.containsKey(vecino.destino())) {
          colaPrioridad.add(new Arista(vecino.destino(), distancia + vecino.peso()));
        }
      }
    }
    return distancias;
  }

  private int contarRutasConDistanciaDFS(String actual, String destino, int maxDistancia,
      int distanciaActual, int conteo) {
    if (distanciaActual >= maxDistancia) {
      return conteo;
    }
    if (distanciaActual > 0 && actual.equals(destino)) {
      conteo++;
    }
    for (Arista arista : listaAdyacencia.getOrDefault(actual, Collections.emptyList())) {
      conteo = contarRutasConDistanciaDFS(arista.destino(), destino, maxDistancia,
          distanciaActual + arista.peso(), conteo);
    }
    return conteo;
  }
}
