@Smoke
Feature: Projects

  Scenario Outline: Consulta de todos los proyectos exitosamente
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    And un id_WSpace
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>

    Examples:
    | operation | entity | jsonName    | status |
    | GET       | PROJECTS| projects/rq | 200    |


  Scenario Outline: Consulta de un proyecto exitosamente por su identificador
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    And un id_WSpace
    When I perform a '<operation>' to 'PROJECTS' endpoint with the 'projects/rq' and ''
    And se obtuvo el status code <status>
    Then se valida que el id no sea null
    Given un id project de la respuesta
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>

    Examples:
      | operation | entity | jsonName    | status  |
      | GET       | PROJECT| projectId/rq | 200    |


  Scenario Outline: Proyecto no autorizado 401
    Given X-Api-Key invalido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Examples:
      | operation | entity | jsonName        | status |
      | GET       | ERROR  | projects/rq_401 | 401    |


  Scenario Outline: Proyecto no encontrado 404
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    And un id_WSpace
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And selecciono un proyecto por su id
    And se obtuvo el status code <status>
    Examples:
      | operation | entity  | jsonName         | status |
      | GET       | PROJECTS   | projects/rq_404 | 404    |


  Scenario Outline: Editar un proyecto exitosamente
    Given Mi cuenta creada en clockify y mi X-Api-Key geneada
    And un id_WSpace
    When I perform a 'GET' to 'PROJECTS' endpoint with the 'projects/rq' and ''
    And se obtuvo el status code <status>
    Given un id project de la respuesta
    And modifico el nombre del proyecto '<name>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se valida que el nombre '<name>' fue editado
    Examples:
      | operation | entity | jsonName            | status |name |
      | PUT       | PROJECT| projectId/rqeditar | 200    |alba25|