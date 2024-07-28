package logic.studio.proyecto.base.controller.logic_studio.command;


import java.util.List;
import logic.studio.record.request.InputsGrafosRequestRecord;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/command/test")
@Validated
public interface TestLogicStudioCommandController {

  @PostMapping("/addGrafos")
  @ResponseStatus(HttpStatus.OK)
  void addGrafos(@RequestBody List<InputsGrafosRequestRecord> inputsGrafosRequestRecords);

  @PostMapping("/clear")
  @ResponseStatus(HttpStatus.OK)
  void clear();

  @PostMapping("/routes")
  @ResponseStatus(HttpStatus.OK)
  void findRoutes();
}
