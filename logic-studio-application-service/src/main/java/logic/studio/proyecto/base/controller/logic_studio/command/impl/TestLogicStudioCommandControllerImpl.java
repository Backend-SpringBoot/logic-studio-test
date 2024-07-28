package logic.studio.proyecto.base.controller.logic_studio.command.impl;

import java.util.List;
import logic.studio.domain.application.ports.input.logic_studio.command.TestLogicStudioCommandService;
import logic.studio.proyecto.base.controller.logic_studio.command.TestLogicStudioCommandController;
import logic.studio.record.request.InputsGrafosRequestRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestLogicStudioCommandControllerImpl implements TestLogicStudioCommandController {

  private final TestLogicStudioCommandService testLogicStudioCommandService;

  @Override
  public void addGrafos(List<InputsGrafosRequestRecord> inputsGrafosRequestRecords) {
    testLogicStudioCommandService.addGrafos(inputsGrafosRequestRecords);
  }

  @Override
  public void clear() {
    testLogicStudioCommandService.clear();
  }
}
