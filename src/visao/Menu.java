/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.Scanner;

/**
 *
 * @author 5671060
 */
public class Menu {
    public static void exibirMenu(){
         System.out.println("==== MENU PRINCIPAL ====");
         System.out.println("Seleciona a opção:");
         System.out.println("1) Cadastro de equipamento");
         System.out.println("2) Listagem de equipamentos");
         System.out.println("O que vocÊ deseja fazer?");
         
         Scanner entrada = new Scanner( System.in );
         try {
            int opcao = entrada.nextInt();
            System.out.println("O usuario digitou "+opcao);
        } catch (Exception e) {
            System.out.println("Nao deu certo pq: "+e.getMessage());
        }
         
    }
 
    
}