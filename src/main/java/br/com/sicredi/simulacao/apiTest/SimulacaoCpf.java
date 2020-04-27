package br.com.sicredi.simulacao.apiTest;

import static org.hamcrest.Matchers.*;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Locale;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimulacaoCpf {

    FakeValuesService faker = new FakeValuesService(new Locale("en-US"), new RandomService());

    static final String simulation = "http://localhost:8080/api/v1/simulacoes";
    static final String restricao = "http://localhost:8080/api/v1/restricoes/62648716050";

    public static String jsonAsString;
    private Response response;
    private RequestSpecification request;
    String carga = "{" +
            "\"nome\": \"Fulano de Tal\"," +
            "\"cpf\":" + faker.numerify("###########")+"," +
            "\"email\": \""+faker.letterify("?????")+"@email.com\"," +
            "\"valor\": 1200," +
            "\"parcelas\": 3," +
            "\"seguro\": true" +
            "}";
    String deltranoCpf = "17822386034";
    String cpfRestrito = "62648716050";

    public void acessaParametrosWebservice(){
        request = RestAssured.given().with().relaxedHTTPSValidation().contentType(ContentType.JSON);
    }

    public void consultaTodasAsSimulacoes(){
        response = RestAssured.get(simulation);
    }

    public void exibeTodasAsSimulacoes(){
        response.then().log().ifStatusCodeIsEqualTo(200);
    }

    public void consultaCpfComRestricao(){
        response = RestAssured.get(restricao);
    }

    public void validaCpfRestrito(){
        response.then().body("mensagem", containsString("tem problema")).log().ifStatusCodeIsEqualTo(200);
    }

    public void insereNovaSimulacao(){
        request.body(carga);
        response = request.post(simulation);
    }

    public void validaNovaSimulacaoCriada(){
        response.then().log().ifStatusCodeIsEqualTo(201)
                .body("id", is(notNullValue()))
                .body("nome", is(not(empty())));
        jsonAsString = response.asString();
    }

    public void alteracaoDeSimulacaoCriada(){
        request.body(carga);
        String valuesubstring = jsonAsString.substring(40,51);
        response = request.put(simulation+"/"+valuesubstring);
    }

    public void validaAlteracaoDeSimulacao(){
        response.then().log().ifStatusCodeIsEqualTo(200)
                .body("id", is(notNullValue()))
                .body("nome", is(not(empty())));
    }

    public void exclusaoDeSimulaaco(){
        response = request.delete(simulation+"/"+jsonAsString.substring(6,7));
    }

    public void validaExclusaoDeSimulacao(){
        response.then().log().ifStatusCodeIsEqualTo(200)
                .body(containsString("OK"));
    }

    public void pesquisaUmaSimulacaoPorCpf(){
        response = request.get(simulation+"/"+deltranoCpf);
    }

    public void validaPesquisaPorCpf(){
        response.then()
                .body("nome", containsString("Deltrano"))
                .body("email", containsString("deltrano@gmail"))
                .log().ifStatusCodeIsEqualTo(200);
    }

}
