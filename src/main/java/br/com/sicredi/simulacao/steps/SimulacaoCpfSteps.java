package br.com.sicredi.simulacao.steps;

import br.com.sicredi.simulacao.apiTest.SimulacaoCpf;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.cucumber.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.Matchers.*;

public class SimulacaoCpfSteps {

    SimulacaoCpf simulacaoCpf = new SimulacaoCpf();

    @Dado("que acesso a webservice")
    public void que_acesso_a_webservice() {
        simulacaoCpf.acessaParametrosWebservice();
    }

    @Quando("realizo a consulta das simulações")
    public void realizo_a_consulta_das_simulacoes() {
        simulacaoCpf.consultaTodasAsSimulacoes();
    }
    @Então("exibe no log a lista de todas as simulações")
    public void exibe_no_log_a_lista_de_todas_as_simulacoes() {
        simulacaoCpf.exibeTodasAsSimulacoes();
    }

    @Quando("faço a consulta de simulação com CPF restrito")
    public void faco_a_consulta_de_simulação_com_cpf_restrito() {
        simulacaoCpf.consultaCpfComRestricao();
    }

    @Entao("é exibida mensagem informando que o cpf tem algum problema")
    public void e_exibida_mensagem_informando_que_o_cpf_tem_algum_problema() {
        simulacaoCpf.validaCpfRestrito();

    }

    @Quando("insiro uma nova simulação")
    public void insiro_uma_nova_simulacao() {
        simulacaoCpf.insereNovaSimulacao();
    }

    @Então("uma nova simulação é criada")
    public void uma_nova_simulacao_e_criada() {
        simulacaoCpf.validaNovaSimulacaoCriada();
    }

    @Quando("altero uma simulação já criada")
    public void altero_uma_simulacao_ja_criada() {
        simulacaoCpf.alteracaoDeSimulacaoCriada();
    }

    @Então("realiza a alteração com sucesso exibindo status de sucesso")
    public void realiza_a_alteracao_com_sucesso_exibindo_status_de_sucesso() {
        simulacaoCpf.validaAlteracaoDeSimulacao();
    }

    @Quando("solicito a exclusão de uma simulação")
    public void solicito_a_exclusao_de_uma_simulacao() {
       simulacaoCpf.exclusaoDeSimulaaco();
    }

    @Então("exibe uma mensagem de Ok informando a exclusão com sucesso")
    public void exibe_uma_mensagem_de_Ok_informando_a_exclusao_com_sucesso() {
        simulacaoCpf.validaExclusaoDeSimulacao();
    }

    @Quando("pesquisa por um cpf da lista de simulações")
    public void pesquisa_por_um_cpf_da_lista_de_simulacoes() {
        simulacaoCpf.pesquisaUmaSimulacaoPorCpf();
    }

    @Então("exibe os dados do cpf pesquisado")
    public void exibe_os_dados_do_cpf_pesquisado() {
        simulacaoCpf.validaPesquisaPorCpf();

    }
}


