package services;
import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;


public class ProjectEditService extends BaseService {

  public static Response get(String jsonName) {
      return get(jsonName, ProjectResponse.class,setParams());
     }

    static Map<String,String> setParams(){
        Map<String,String> params= new HashMap<>();
        params.put("api-key",API_KEY.get());
        params.put("id_project",ID_PROJECT.get());
        return params;
    }
    public static Response put(String jsonName) {
        return put(jsonName, ProjectResponse.class, setParamsPut(setParams()));
    }

    private static Map<String, String> setParamsPut(Map<String, String> params) {
        params.put("name", NAME_PROJECT.get());
        return params;

    }
}
