package controller.clienteController;

import model.pessoa.Pessoa;
import service.serviceCliente.ClienteValidationService;

import static java.lang.Character.isUpperCase;

public class ClienteValidationController {

    public static boolean clienteValidationCadastro(Pessoa pessoa){
        if(pessoa.getNome().trim().isEmpty()||pessoa.getNome().trim().length()==2) throw new IllegalArgumentException("Nome Invalido");
        if(pessoa.getCpf().length()!=12) throw new IllegalArgumentException("Cpf deve estar nesse formato 'xxxxxxxxx-xx'");
        if(ClienteValidationController.validacaoDataDeNascimento(pessoa)<1930)throw new IllegalArgumentException("Idade invalida");
        if(pessoa.getDataDeNascimento().length()!=10||ClienteValidationController.validacaoDataDeNascimento(pessoa)==0) throw new IllegalArgumentException("Data de nascimento deve estar nesse formato 00/00/0000");
        return ClienteValidationService.validationCadastroCliente(new Pessoa(ClienteValidationController.formatandoNome(pessoa), pessoa.getCpf(), pessoa.getDataDeNascimento()));
    }

    public static String formatandoNome(Pessoa pessoa){
        String nomeCompleto = "";
        String letra;
        String[] nomes = pessoa.getNome().split(" ");
        for (String nome : nomes) {
            char c = nome.charAt(0);
            letra = c + "";
            nomeCompleto += letra.toUpperCase() + nome.substring(1) + " ";
        }
        return nomeCompleto;
    }

    private static int validacaoDataDeNascimento(Pessoa dataDeNascimento){
        //atualizar, trocar a string por pessoa.getData...
        char[] dataArray = dataDeNascimento.getDataDeNascimento().trim().toCharArray();
        String anoString = "";
        int ano = 0;

        for(int i = 6; i < dataArray.length; i++){
           anoString += dataArray[i];
        }

        try{
            ano = Integer.parseInt(anoString);
            return ano;
        }catch (NumberFormatException e){
            e.getMessage();
        }

        return ano;
    }
}
