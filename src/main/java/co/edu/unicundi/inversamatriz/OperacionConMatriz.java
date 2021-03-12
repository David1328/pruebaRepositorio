/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.inversamatriz;

import logica.LogicaMatriz;

/**
 *
 * @author David
 */
public class OperacionConMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LogicaMatriz matriz = new LogicaMatriz();
        matriz.llenarMatriz();
        System.out.println("Determinante   "+matriz.hallarDeterminante());
        matriz.matrizAdjunta();
        matriz.matrizInversa();
    }
    
}
