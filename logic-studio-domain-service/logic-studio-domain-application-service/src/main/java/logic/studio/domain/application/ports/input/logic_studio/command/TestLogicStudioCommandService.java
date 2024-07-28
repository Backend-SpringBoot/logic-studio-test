package logic.studio.domain.application.ports.input.logic_studio.command;

import java.util.List;
import logic.studio.record.request.InputsGrafosRequestRecord;

public interface TestLogicStudioCommandService {

  void addGrafos(List<InputsGrafosRequestRecord> inputsGrafosRequestRecords);

  void clear();

  void calcularYMostrarResultados();
}
