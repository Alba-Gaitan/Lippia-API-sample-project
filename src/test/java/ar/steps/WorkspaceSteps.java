package ar.steps;

import ar.validator.WorkspaceValidator;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;
import services.ErrorService;

public class WorkspaceSteps extends PageSteps {

    @Given("Mi cuenta creada en clockify y mi X-Api-Key geneada")
    public void miCuentaCreadaEnClockifyYMiXApiKeyGeneada() {
        BaseService.API_KEY.set("Nzk3ZGJlZDMtNTQxNC00MjlkLTgzYjktYTRjZGM4NTQ1MjIz");
    }

    @Then("Obtengo los datos de mi Workspace")
    public void obtengoLosDatosDeMiWorkspace() {
        WorkspaceValidator.validate();
    }

    @Given("X-Api-Key invalido")
    public void xApiKeyInvalido() {
        BaseService.API_KEY.set("Nzk3ZGJlZDMtNTQxNC00MjlkLTgzYjktYTRjZGM4NTQ1MjI1");
    }
}
