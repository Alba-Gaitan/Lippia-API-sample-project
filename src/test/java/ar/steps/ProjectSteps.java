package ar.steps;

import api.model.Project.ProjectResponse;
import ar.validator.ProjectValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;
import services.ProjectEditService;
import services.ProjectService;
import services.ProjectsService;

public class ProjectSteps extends PageSteps {
    ProjectValidator validator=  new ProjectValidator();

    @Then("se valida que el id no sea null")
    public void seValidaQueElIdNoSeaNull() {
    validator.validate();
    }

    @And("un id_WSpace")
    public void unId_WSpace() {
        ProjectsService.ID_W_SPACE.set("6354623028051215c2f00789");
    }

    @Given("un id project de la respuesta")
    public void unIdProjectDeLaRespuesta() {
        ProjectResponse[]idProject;
        idProject = (ProjectResponse[])APIManager.getLastResponse().getResponse();
        ProjectsService.ID_PROJECT.set(idProject[0].getId());
    }

    @And("selecciono un proyecto por su id")
    public void seleccionoUnProyectoPorSuId() {
        BaseService.ID_PROJECT.set("6355e6823da4c53079e6a9a9");
    }

    @And("modifico el nombre del proyecto '(.*)'$")
    public void modificoElNombreDelProyectoNombre(String name) {
        ProjectService.NAME_PROJECT.set(name);
    }

    @Then("se valida que el nombre {string} fue editado")
    public void seValidaQueElNombreNameFueEditado(String name) {
        validator.validateName(name);
    }
}
