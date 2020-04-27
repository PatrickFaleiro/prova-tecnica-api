package br.com.sicredi.simulacao.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = "src/main/java/br/com/sicredi/simulacao/features",
        monochrome=true,
        glue = { "br.com.sicredi.simulacao.steps" })
public class SimulacaoCpfRunner {


}
