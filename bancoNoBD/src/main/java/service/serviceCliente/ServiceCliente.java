package service.serviceCliente;


import model.pessoa.clientes.Cliente;

public class ServiceCliente {

    public static int getIdade(Cliente cliente){ //pegar a data atual e retornar a idade nao apenas com o ano mas com o mes tbm

        String data = cliente.getDataDeNascimento();
        char[] dataArray = data.toCharArray();
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

    public static boolean cadastrarCliente(){
        return false;
    }

    public static boolean deletarCliente(){
        return false;
    }

    public static Cliente getCliente(){
        return null;
    }

    public static boolean updateClienteName(){
        return false;
    }
}
