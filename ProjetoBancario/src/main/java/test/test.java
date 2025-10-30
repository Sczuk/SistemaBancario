package test;


import controller.clienteController.ClienteValidationController;
import model.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class test {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("henrique gabriel rea sczuk","123456789-00","21/03/2008");

        System.out.println(ClienteValidationController.formatandoNome(pessoa));
    }
}
