package service.serviceCliente;

import model.pessoa.Pessoa;
import repository.repositoryCliente.ClienteRepository;

import java.util.List;

public class ClienteValidationService {

    public static int getIdade(String dataDeNascimento){ //pegar a data atual e retornar a idade nao apenas com o ano mas com o mes tbm
        char[] dataArray = dataDeNascimento.toCharArray();
        char[] anoArray = new char[4];
        int anoNascimento = 0;
        String anoString = "";

        for(int i = 6; i < dataArray.length; i++){
            anoArray[i-6] = dataArray[i];
        }
        for(char c : anoArray){
            anoString += c;
        }

        try {
            anoNascimento = Integer.parseInt(anoString);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }

        int idade = 2025 - anoNascimento;
        return idade;
    }

    public static boolean validationCadastroCliente(Pessoa pessoa){
        List<Pessoa> pessoas = ClienteRepository.getCpfs();
        for(Pessoa p : pessoas){
            if(p.getCpf().equals(pessoa.getCpf()))throw new IllegalArgumentException("Cpf invalido");
        }

        if(ClienteValidationService.getIdade(pessoa.getDataDeNascimento()) > 17) {
            ClienteMaiorService.cadastrarCliente(pessoa);
            return true;
        }

        if(ClienteValidationService.getIdade(pessoa.getDataDeNascimento()) < 18) {
            ClienteMenorService.cadastrarClienteMenor(pessoa);
            return true;
        }else{
            return false;
        }
    }

}
