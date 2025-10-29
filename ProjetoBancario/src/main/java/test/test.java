package test;


import controller.clienteController.ClienteValidationController;
import model.pessoa.Pessoa;


public class test {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("","567891012-13","01/09/2000");
        ClienteValidationController.clienteValidationCadastro(pessoa);

    }
}
