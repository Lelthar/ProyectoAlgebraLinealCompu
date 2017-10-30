/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebraprogra;

/**
 *
 * @author gerald
 */
public class Operaciones {

    public Operaciones() {
        
    }
    
    public double[] calcularTransformacionIsometrica(double[] vector){
        double[] resultado = new double[2];
        resultado[0] = vector[1]-vector[0];
        resultado[1] = -0.5 * (vector[0]+vector[1]-2*vector[2]);
        return resultado;
    }
    
    public double[] gaussJordan(double[][] matriz,double[] vector){
        matriz = matrizTranspuesta(matriz);
        int m = matriz.length;
        double[] x = vectorCeros(m);
        
        for(int k = 0; k < m; k++){
            for(int r = k+1; r < m; r++){
                double factor = (matriz[r][k]/matriz[k][k]);
                vector[r] = vector[r] - (factor*vector[k]);
                for(int c = 0; c < m; c++){
                    matriz[r][c] = matriz[r][c] - (factor*matriz[k][c]); 
                }
            }
        }
        x[m-1] = vector[m-1] / matriz[m-1][m-1];
        
        for(int r = m-2; r > -1; r-=1){
            
            double suma = 0;
            for(int c = 0; c < m; c++){
                suma = suma + matriz[r][c]*x[c];
            }
            x[r] = (vector[r] - suma) / matriz[r][r];
        }
        return x;
    }
    
    public double[][] matrizTranspuesta(double[][] matriz){
        double[][] resultado = new double[matriz[0].length][matriz.length];
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                resultado[j][i] = matriz[i][j];
            }
        }
        return resultado;
    }
    
    public double[] vectorCeros(int cantidad){
        double[] resultado = new double[cantidad];
        
        for(int i = 0; i < cantidad; i++){
            resultado[i] = 0;
        }
        return resultado;
    }
    
    public boolean baseLinealmenteIndependiente(double[] vector){
        for(int i = 0; i < vector.length; i++){
            if(vector[i] != 0){
                return false;
            }
        }
        return true;
    }
    
    public double[] extractorVectorString(String vector, int cantidad){
        double[] resultado = new double[cantidad];
        String numero = "";
        int contador = 0;
        for(int i = 0; i < vector.length(); i++){
            if(vector.charAt(i) == ','){
                resultado[contador] = Double.parseDouble(numero);
                numero = "";
                contador++;
            }else if(i+1 == vector.length()){
                //numero += vector.charAt(i);
                resultado[contador] = Double.parseDouble(numero);
                contador++;
                numero = "";
            }else if(i != 0){
                numero += vector.charAt(i);
            }
        }
        
        return resultado;
    }
    
    public double[] calcularRotacion(int grados,double[] vector){
        double[][] matriz = new double[3][3];
        double[] resultado = new double[3];
        
        double gradosRadianes = Math.round(Math.toRadians(grados)*10000d)/10000d;
        
        matriz[0][0] = Math.round(Math.cos(gradosRadianes)*10000d)/10000d;
        matriz[0][1] = Math.round(-Math.sin(gradosRadianes)*10000d)/10000d;
        matriz[0][2] = 0;
        matriz[1][0] = Math.round(Math.sin(gradosRadianes)*10000d)/10000d;
        matriz[1][1] = Math.round(Math.cos(gradosRadianes)*10000d)/10000d;
        matriz[1][2] = 0;
        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 1;
        
        
        double suma = 0;
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < 1; j++){
                suma = 0;
                for(int k = 0; k < matriz[0].length; k++){
                    suma += (matriz[i][k]*vector[k]);
                }
            }
            
            resultado[i] = suma;
        }
        return resultado;
    }
    
    public double[] multiplicarVectorXEscalar(double[] vector, double escalar){
        double[] resultado = new double[vector.length];
        for(int i = 0; i < vector.length; i++){
            resultado[i] = (vector[i]*escalar);
        }
        return resultado;
    }
    
}
