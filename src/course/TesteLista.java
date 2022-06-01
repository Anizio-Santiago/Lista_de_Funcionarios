package course;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TesteLista<list> {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> list = new ArrayList<Funcionario>(); // Instanciando a classe detro da lista.

        System.out.print("Informe quantos funcionario serão cadastrados: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){ // For para adionar dados dentro da lista.
            System.out.println();
            System.out.print("Funcionario # " + (i + 1) + ":");
            System.out.print("Id: ") ;
            Integer id = sc.nextInt();

            while(temId(list,id)){  // Continuação da função estática para verificar se o Id Já existe.
                System.out.println("Esse Id já existe, tente novamente!");
                id = sc.nextInt();
            }

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salario : ");
            Double salario = sc.nextDouble();

            Funcionario func = new Funcionario(nome,id,salario);

            list.add(func);
        }

        System.out.print("Informe o id do funcionario que recebera o aumento: ");
        int  idSalario =  sc.nextInt();

        Funcionario func = list.stream().filter(x -> x.getId() == idSalario).findFirst().orElse(null);// função lambda

        //Integer posi = posicao(list,idSalario);
        if(func == null){
            System.out.println("O id informado nao existe");
        } else{
            System.out.print("Informe a porcentagem a ser adicionada");
            double porcent = sc.nextDouble();
            func.acresentaSalario(porcent);
        }
        System.out.println();
        System.out.println("Dados dos funcionarios: ");

        for(Funcionario f : list ){ // For eath para imprimir a lista.
            System.out.println(func);
        }

     sc.close();
    }
    public static Integer posicao(List<Funcionario> list, int id){     //Metodo para retornar a posição do id na lista.
        for(int i = 0 ; i < list.size(); i ++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

    public static boolean temId(List<Funcionario> list, int id){  // Função estática para verificar se o id exite.
        Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return func != null;

    }

}
