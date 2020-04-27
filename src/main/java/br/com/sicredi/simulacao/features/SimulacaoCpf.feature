# language: pt

  Funcionalidade: Testes de API para consulta de CPF
    Cenario: Consulta todas as simulações
      Dado que acesso a webservice
      Quando realizo a consulta das simulações
      Então exibe no log a lista de todas as simulações

    Cenario: Consulta cpf da lista de simulações
      Dado que acesso a webservice
      Quando pesquisa por um cpf da lista de simulações
      Então exibe os dados do cpf pesquisado

    Cenario: Consulta simulação com CPF restrito
      Dado que acesso a webservice
      Quando faço a consulta de simulação com CPF restrito
      Entao é exibida mensagem informando que o cpf tem algum problema

    Cenario: Inserção de uma simulação
      Dado que acesso a webservice
      Quando insiro uma nova simulação
      Então uma nova simulação é criada

    Cenario: Alteração de uma simulação
      Dado que acesso a webservice
      Quando altero uma simulação já criada
      Então realiza a alteração com sucesso exibindo status de sucesso

    Cenario: Exclusão de uma simulação
      Dado que acesso a webservice
      Quando solicito a exclusão de uma simulação
      Então exibe uma mensagem de Ok informando a exclusão com sucesso