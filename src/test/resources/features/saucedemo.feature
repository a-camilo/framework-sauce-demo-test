@sauce_demo
Feature: Sauce Demo Login

  Background:
    Given que o usuário está na página de login "https://www.saucedemo.com/"

  @cenario_1
  Scenario: Login com sucesso para usuário padrão
    When o usuário insere "standard_user" como usuário
    And o usuário insere "secret_sauce" como senha
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário

  @cenario_2
  Scenario: Login com sucesso para usuário padrão
    When o usuário insere login "standard_user" e password "secret_sauce"
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário

  @cenario_3
  Scenario: Login com usuário bloqueado
    When o usuário insere "locked_out_user" como usuário
    And o usuário insere "secret_sauce_" como senha
    And o usuário clica no botão de login
    Then o usuário deve ver uma mensagem de erro

  @cenario_4
  Scenario: Login com sucesso para usuário com problema
    When o usuário insere "problem_user" como usuário
    And o usuário insere "secret_sauce" como senha
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário

  @cenario_5
  Scenario: Login com sucesso para usuário de performance
    When o usuário insere "performance_glitch_user" como usuário
    And o usuário insere "secret_sauce" como senha
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário

  @cenario_6
  Scenario: Login com erro de senha
    When o usuário insere "standard_user" como usuário
    And o usuário insere "senha_incorreta" como senha
    And o usuário clica no botão de login
    Then o usuário deve ver uma mensagem de erro

  @cenario_7
  Scenario: Login com usuário não aceito
    When o usuário insere "error_user" como usuário
    And o usuário insere "secret_sauce" como senha
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário

  @cenario_8
  Scenario: Login com usuário visual
    When o usuário insere "visual_user" como usuário
    And o usuário insere "secret_sauce" como senha
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário

  @cenario_9
  Scenario:  Usuário escolhe produto
    When o usuário insere "standard_user" como usuário
    And o usuário insere "secret_sauce" como senha
    And o usuário clica no botão de login
    Then o usuário deve ser redirecionado para a página do inventário
    And escolhe o produto
      | produto                           |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |