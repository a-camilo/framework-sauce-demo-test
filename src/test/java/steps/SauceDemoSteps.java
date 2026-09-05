package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import page.SauceDemoPage;

public class SauceDemoSteps {

    @Dado("que o usuário está na página de login {string}")
    public void que_o_usuário_está_na_página_de_login(String urlPage) {
        SauceDemoPage.action().urlPage(urlPage);
    }

    @Quando("o usuário insere {string} como usuário")
    public void o_usuario_insere_como_usuario(String username) {
        SauceDemoPage.action().username(username);
    }

    @Quando("o usuário insere {string} como senha")
    public void o_usuario_insere_como_senha(String password) {
        SauceDemoPage.action().password(password);
    }

    @Quando("o usuário clica no botão de login")
    public void o_usuario_clica_no_botao_de_login() {
        SauceDemoPage.action().loginButton();
    }

    @Entao("o usuário deve ser redirecionado para a página do inventário")
    public void o_usuario_deve_ser_redirecionado_para_a_pagina_do_inventario() {
        SauceDemoPage.action().assertTitle("Swag Labs");
    }

    @E("escolhe o produto")
    public void escolhe_o_produto(DataTable produto) {
        SauceDemoPage.action()
                .produto(produto)
                .shoppingCart()
                .checkoutInfo()
                .summaryInfo()
        ;
    }

    @Entao("o usuário deve ver uma mensagem de erro")
    public void o_usuario_deve_ver_uma_mensagem_de_erro() {
        SauceDemoPage.action().assertError();
    }

    @Quando("o usuário insere login {string} e password {string}")
    public void oUsuárioInsereLoginEPassword(String login, String password) {
        SauceDemoPage.action().loginEPassword(login,password);
    }

}

