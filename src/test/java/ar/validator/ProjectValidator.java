package ar.validator;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class ProjectValidator {
    //validar un campo
    public void validate(){
        ProjectResponse[] response = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
        for (ProjectResponse project: response) {
            Assert.assertNotNull(project.getId(),"el id es null");
        };
    }
    public void validateName(String name){
        ProjectResponse response = (ProjectResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(response.getName(),name,"nombre modificado");
    }


}
