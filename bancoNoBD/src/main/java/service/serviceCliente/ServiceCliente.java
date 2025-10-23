package service.serviceCliente;


import model.pessoa.Pessoa;
import model.pessoa.clientes.Cliente;

import java.util.Arrays;

public class ServiceCliente {

    public static int getIdade(Cliente cliente){ //pegar a data atual e retornar a idade nao apenas com o ano mas com o mes tbm
        StringBuilder sb = new StringBuilder();
        String data = cliente.getDataDeNascimento();
        char[] dataArray = data.toCharArray();
        char[] anoArray = new char[4];
        int anoNascimento = 0;

        for(int i = 6; i < dataArray.length; i++){
            anoArray[i-6] = dataArray[i];
        }

        for(char c : anoArray){
            sb.append(c);
        }

        String anoString = sb.toString();

        try {
            anoNascimento = Integer.parseInt(anoString);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Ano nao correspondente a um numero");
        }

        int idade = 2025 - anoNascimento;
        return idade;
    }
}
