package controller.clienteController;

import model.pessoa.Pessoa;
import service.serviceCliente.ClienteValidationService;

public class ClienteValidationController {

    public static boolean clienteValidationCadastro(Pessoa pessoa){
        if(pessoa.getNome().trim().isEmpty()||pessoa.getNome().trim().length()==2) throw new NullPointerException("Nome Invalido");
        if(pessoa.getCpf().length()!=12) throw new IllegalArgumentException("Cpf deve estar nesse formato 'xxxxxxxxx-xx'");
        if(pessoa.getDataDeNascimento().length()!=10||!ClienteValidationController.validacaoDataDeNascimento(pessoa.getDataDeNascimento())) throw new IllegalArgumentException("Data de nascimento deve estar nesse formato 00/00/0000");
        if(ClienteValidationService.validationCadastroCliente(new Pessoa(ClienteValidationController.formatandoNome(pessoa), pessoa.getCpf(), pessoa.getDataDeNascimento()))) return true;
        return false;
    }

    private static String formatandoNome(Pessoa pessoa){
        String primeiraLetra = pessoa.getNome().substring(0,1).toUpperCase();
        String palavra = pessoa.getNome().substring(1);
        String nomeComLetraMaiscula = primeiraLetra+palavra;
        return nomeComLetraMaiscula;
    }

    private static boolean validacaoDataDeNascimento(String dataDeNascimento){
        char[] dataArray = dataDeNascimento.trim().toCharArray();
        String anoString = "";
        int ano = 0;

        for(int i = 6; i < dataArray.length; i++){
           anoString += dataArray[i];
        }

        try{
            ano = Integer.parseInt(anoString);
            return true;
        }catch (NumberFormatException e){
            e.getMessage();
        }

        return false;
    }
}
