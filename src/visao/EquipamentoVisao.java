/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.EquipamentoControle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Equipamento;

/**
 *
 * @author 5671060
 */
public class EquipamentoVisao {
    public static void exibirFormularioCadastroEquipamento(){
        Scanner entrada = new Scanner( System.in);
        System.out.println("=== TELA DE CADASTRO DE EQUIPAMENTO ===");
        String nome, patrimonio;
        Date dataAquisicao, dataTerminoGarantia;
        float valor;
        
        System.out.println("Informe o nome: ");
        nome = entrada.nextLine();
        System.out.println("Número de patrimônio: ");
        patrimonio = entrada.nextLine();
        System.out.println("Informe a data de aquisição: ");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
            try{
                dataAquisicao = formatadorData.parse(entrada.nextLine());
                 System.out.println("Data lida: "+dataAquisicao);
            }catch(Exception e){
                 System.out.println("Data inválida!!!");
            }
        }while(true);
        System.out.println("Informe a data e término da garantia: ");
        do{
            try{
                dataTerminoGarantia = formatadorData.parse(entrada.nextLine());
                if(dataTerminoGarantia.after(dataAquisicao)){
                    break;
                }else{
                    System.out.println("Data de término da garantia deve ser posterio a data de aquisicao");
                }
                 System.out.println("Data lida: "+dataAquisicao);
            }catch(Exception e){
                 System.out.println("Data inválida!!!");
            }
        }while(true);
        System.out.println("Informe o valor: ");
        

         EquipamentoControle.receberDadosCadastroEquipamento(nome, patrimonio, dataAquisicao, dataTerminoGarantia, valor);
         Menu.exibirMenu();        
    }
    
    public static void exibirListagemEquipamentos(){
        System.out.println("=== TELA DE LISTAGEM DE EQUIPAMENTOS ===");
        
        System.out.println("NOME \t Data Aquisição\t numero de manutencoes");
//        ArrayList<Equipamento> lista = EquipamentoControle.obterListaEquipamentos();
//        for(int i=0; i < EquipamentoControle.obterListaEquipamentos().size(); i++){
//                System.out.println(lista.get(i).getNome()+"\t"+lista.get(i).getDataAquisicao());
//        }
        for(Equipamento obj : EquipamentoControle.obterListaEquipamentos()){
                System.out.println(obj.getNome()+"\t"+obj.getDataAquisicao()+"\t"+obj.getListaManutencoes().size());
        }
        
        System.out.println("O que deseja fazer?");
        System.out.println("0) voltar ao menu");
        System.out.println("numero patrimônio) Cadastrar manutenção para o equipamento");
        
        Scanner entrada = new Scanner(System.in);
        String valorDigitado = entrada.nextLine();
        
        if(entrada.equals("0")){
            Menu.exibirMenu();
        }else{
            Equipamento encontrado = EquipamentoControle.obterEquipamentoPeloNumeroDoPatrimonio(valorDigitado);
            if(encontrado == null){
                System.out.println("ERRO: nÃO encontrei");
                Menu.exibirMenu();
            }else{
                
            }
        }
    }
}
