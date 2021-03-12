package logica;
/**
 *
 * @author David
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class LogicaMatriz {
    private float matriz[][];
    private float matrizAdjunta[][];
    private float deter;
    
    //Metodo que permite solictar y llenar la matriz
    public void llenarMatriz(){
        Scanner in = new Scanner(System.in);
        setMatriz(new float[3][3]);
        //int matriz1[][] ={{2,3,1},{1,-1,2},{0,1,0}};
        //int matriz1[][] ={{5,-2,3},{1,2,2},{-4,-1,3}};
        //float matriz1[][] ={{1,-2,5},{3,3,-1},{0,4,-2}};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println("Ingresa valor la posición ["+i+"]["+j+"]");
                getMatriz()[i][j]= in.nextInt();
            }
        }
        mostrarMatriz(getMatriz(),"Matriz inicial");
    }
    
    //Metodo que permite imprimir cualquier matriz con su nombre
    public void mostrarMatriz(float matriz[][],String nombreMatriz){
        System.out.println("Impresion de "+ nombreMatriz);
        DecimalFormat formato1 = new DecimalFormat("#.00");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(formato1.format(matriz[i][j])+" ");
            }
            System.out.print("\n");
        }
    }
    //Metodo que permite hallar el terminante
    public float hallarDeterminante(){
        setDeter(determinaConCofactores(getMatriz()[0][0], getMatriz()[1][1], getMatriz()[2][2], getMatriz()[1][2], getMatriz()[2][1]));
        setDeter(getDeter() + -1 * determinaConCofactores(getMatriz()[0][1], getMatriz()[1][0], getMatriz()[2][2], getMatriz()[1][2], getMatriz()[2][0]));
        setDeter(getDeter() + determinaConCofactores(getMatriz()[0][2], getMatriz()[1][0], getMatriz()[2][1], getMatriz()[1][1], getMatriz()[2][0]));
        return getDeter();
    }
    //Funcion que permite hallar usando cofactores para determinantes
    public float determinaConCofactores(float numfila,float num1,float num2, float num3, float num4){
        
        float respuesta= numfila*((num1*num2)-1*(num3*num4));
        return respuesta;
        
    }
    //Permite hallar la matriz adjunta
    public void matrizAdjunta (){
        float tablaA[][]= getMatriz();
        setMatrizAdjunta(new float[3][3]);
        getMatrizAdjunta()[0][0]=(tablaA[1][1]*tablaA[2][2]) - (tablaA[1][2]*tablaA[2][1]);
        getMatrizAdjunta()[0][1]=-((tablaA[0][1]*tablaA[2][2]) - (tablaA[0][2]*tablaA[2][1]));
        getMatrizAdjunta()[0][2]=(tablaA[0][1]*tablaA[1][2]) - (tablaA[0][2]*tablaA[1][1]);
        
        getMatrizAdjunta()[1][0]=-((tablaA[1][0]*tablaA[2][2]) - (tablaA[1][2]*tablaA[2][0]));
        getMatrizAdjunta()[1][2]=-((tablaA[0][0]*tablaA[1][2]) - (tablaA[0][2]*tablaA[1][0]));
        getMatrizAdjunta()[1][1]=(tablaA[0][0]*tablaA[2][2]) - (tablaA[0][2]*tablaA[2][0]);
        
        getMatrizAdjunta()[2][0]=(tablaA[1][0]*tablaA[2][1]) - (tablaA[1][1]*tablaA[2][0]);
        getMatrizAdjunta()[2][1]=-((tablaA[0][0]*tablaA[2][1]) - (tablaA[0][1]*tablaA[2][0]));
        getMatrizAdjunta()[2][2]=(tablaA[0][0]*tablaA[1][1]) - (tablaA[0][1]*tablaA[1][0]);
        mostrarMatriz(getMatrizAdjunta(),"Matriz adjunta");
    }
    //Permite hallar la matriz inversa usando el determinate
    public void matrizInversa(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //System.out.println("");getDeter();
                getMatriz()[i][j] = getMatrizAdjunta()[i][j]/getDeter();
            }
        }
            mostrarMatriz(getMatriz(),"Matriz inversa");
    }
    
    //Metodos de encapsulacion
    /**
     * @return the matriz
     */
    public float[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(float[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @return the matrizAdjunta
     */
    public float[][] getMatrizAdjunta() {
        return matrizAdjunta;
    }

    /**
     * @param matrizAdjunta the matrizAdjunta to set
     */
    public void setMatrizAdjunta(float[][] matrizAdjunta) {
        this.matrizAdjunta = matrizAdjunta;
    }

    /**
     * @return the deter
     */
    public float getDeter() {
        return deter;
    }

    /**
     * @param deter the deter to set
     */
    public void setDeter(float deter) {
        this.deter = deter;
    }
}
