package one.dio.gft.desafio_projeto;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MyDog implements Comportamento{

    Scanner scan = new Scanner(System.in);
    private String nome;
    private final List<String> estomago = new ArrayList<>();





    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }






    @Override
    public void comer() {
        String comida;
        boolean fimLoop = true;
        do {
            if (estomago.size() == 3) {
                System.out.println("\nBarriga cheia!\nPreciso digerir um pouco dessa comida...");
                System.out.println("\n"+estomago);
                digerir();
                fimLoop=false;
            } else if(estomago.size() <= 2){
                System.out.println("\nOba, hora do lanche! O que temos para comer? ");
                comida = scan.next();
                estomago.add(comida);

            }
        }while(fimLoop);

    }

    @Override
    public void digerir(){
        System.out.println("\nPode me levar ao banheiro? [S] [N]");
        String opcao = scan.next();
        if(opcao.equalsIgnoreCase("S")){

            do{
                estomago.remove(estomago.get(0));
            }while(estomago.size() > 0);


        }
        if(estomago.isEmpty()){
            System.out.println("\nMinha barriga agora está vazia...");
            alimentar();
        }else{
            verBarriga();
        }

    }

    @Override
    public void nomear() {
        System.out.println("Olá, eu sou seu novo cão-amigo!\nComo gostaria de me chamar? ");
        setNome(scan.next());
        System.out.println(getNome()+", é um lindo nome. Eu adorei!");
    }

    public void verBarriga(){
        System.out.println("\n\nIsso é o que tem na minha barriguinha:\n"+estomago);
        alimentar();

    }

    private void alimentar() {
        System.out.println("\nGostaria de me alimentar? [S] [N]");
        String opcao = scan.next();
        if(opcao.equalsIgnoreCase("S")){
            comer();
        }else{
            System.out.println("\nCerto, vou descansar agora...");
            dormir();
        }
    }

    public void dormir(){
        System.out.println("\nzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }
}
