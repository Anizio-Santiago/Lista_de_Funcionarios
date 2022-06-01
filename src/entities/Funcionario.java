package entities;

public class Funcionario {
    private Integer id;
    private String nome;
    private Double salario;

    public Funcionario(){

    }
    public Funcionario(String nome , Integer id, Double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }


    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }


    public Double getSalario(){
        return salario;
    }

    public void acresentaSalario(double porcentagem){
        salario += salario * porcentagem / 100;
    }

    public String toString(){
        return id
                + ", "
                + nome
                + ", "
                + String.format("%.2f",salario);
    }


}
