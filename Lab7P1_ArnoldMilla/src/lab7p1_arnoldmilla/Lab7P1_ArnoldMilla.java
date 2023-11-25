package lab7p1_arnoldmilla;
import java.util.Scanner;
import java.util.Random;

//fila 2 silla 10

public class Lab7P1_ArnoldMilla {
static Scanner sc = new Scanner(System.in);
static Random rand = new Random();
    
    public static void main(String[] args) {
        System.out.println("-------Menu-------");
        System.out.println("1. Tres en raya"); 
        System.out.println("2. Puntos de silla");
        System.out.println("3. Salir");
        System.out.println("Elija una opcion [1,2,3]");
        int op = sc.nextInt();
        while (op > 0 && op < 3){
            switch(op){
                case 1:{
                    System.out.println("--- Bienvenido al tres en raya---");
                    int size = 3;
                    char charM [][] = new char [3][3];
                    
                    char continuar = 's';
                    boolean victoria = false;
                    char turno = 'X';
                    int row = 0;
                    int column = 0;
                    boolean verif;
                    boolean salir = true;
                    int tnoc = 0;
                    charM = generarTablero(charM);
                    
                    while (continuar == 's' || continuar == 'S'){
                        while (victoria != true){
                            
                            while (turno == 'X'){
                                System.out.println("Tablero actual");
                                imprimir(charM);
                                System.out.println("");
                                System.out.println("Es el turno de: " + turno);
                                System.out.println("Ingrese la fila (0,1,2)");
                                row = sc.nextInt();
                                System.out.println("Ingrese la columna (0,1,2)");
                                column = sc.nextInt();
                                verif = verificarPosicionValida(charM, row, column);
                                salir = true;
                                while (salir == true){
                                if (verif == true){
                                    for (int contador = 0; contador < charM.length; contador++) {
                                        for (int cont = 0; cont < charM[0].length; cont++) {
                                            if(cont == column && contador == row){
                                                charM[contador][cont] = 'X';
                                                salir = false;
                                                break;
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Numero no valido");
                                        System.out.println("Ingrese otra fila");
                                        row = sc.nextInt();
                                        System.out.println("Ingrese otra columna");
                                        column = sc.nextInt();
                                        verif = verificarPosicionValida(charM,row,column);
                                    }
                                }
                                
                                boolean victoriaU = verificarVictoria(charM);
                                if (victoriaU == true){
                                    victoria = true;
                                    imprimir(charM);
                                    System.out.println("Gano el usuario");
                                    break;
                                }
                                tnoc++;
                                if (tnoc == 9){
                                    imprimir(charM);
                                    System.out.println("Empate");
                                    break;
                                }
                                imprimir(charM);
                                turno = '0';
                                
                            }//while turno del usuario
                            while (turno == '0'){
                                System.out.println("Tablero actual");
                                System.out.println("Es el turno de: " + turno);
                                System.out.println("");
                                imprimir(charM);                               
                                row = rand.nextInt(0,2);
                               
                                column = rand.nextInt(0,2);
                                
                                verif = verificarPosicionValida(charM, row, column);
                                
                                salir = true;
                                while(verif == false){                            
                                            row = rand.nextInt(0,3);
                                            column = rand.nextInt(0,3);
                                            verif = verificarPosicionValida(charM,row,column);
                                            
                                }
                                if (verif == true){
                                        charM[row][column] = '0';
                                        salir = false;
                                    }

                                boolean victoriaM = victoriaM(charM);
                                if (victoriaM == true){
                                    imprimir(charM);
                                    System.out.println("Gano la maquina");
                                    victoria = true;
                                    break;
                                }
                                
                                tnoc++;
                                if (tnoc == 9){
                                    imprimir(charM);
                                    System.out.println("Empate");                                  
                                    victoria = true;
                                    break;
                                }
                                
                                turno = 'X';
                            }//while turno de la maquina
                        }//while victoria terminar juego
                    tnoc = 0;
                    victoria = false;
                    charM = generarTablero(charM);
                    turno = 'X';
                    System.out.println("Desea continuar? [s/n]");
                    continuar = sc.next().charAt(0);
                    }
                }break;/////////////////////////////////////////////////fin tres en raya
                
                ///////////////////////////////////////////Inicio case 2
                case 2:{
                    System.out.println("Ingrese el tamaño de la matriz");
                    int size = sc.nextInt();
                    
                    int matriz [][] = new int [size][size];
                    matriz = generarIntMatrizAleatoria(size);
                    imprimirI(matriz);
                    encontrarPuntosSilla(matriz);
                }break;////////////////////////////////////////////fin puntos de silla  
            }
            System.out.println("Salio del ejercicio");
        System.out.println("-------Menu-------");
        System.out.println("1. Tres en raya"); 
        System.out.println("2. Puntos de silla");
        System.out.println("3. Salir");
        System.out.println("Elija una opcion [1,2,3]");
        op = sc.nextInt();
        }
    }//fin main
    
    public static char[][] generarTablero(char [][] charM){
        char temporal [][] = new char [charM.length][charM.length];
            for (int contador = 0; contador < temporal.length; contador++) {
                for (int cont = 0; cont < temporal[contador].length; cont++) {
                    temporal [contador][cont] = ' ';
            }
        }
        return temporal;
    }//fin funcion generar tablero
    
    public static boolean verificarPosicionValida(char [][] charM, int row, int column){
        boolean verif = false;
        
        if (charM[row][column] == ' '){
            verif = true;
        }
        
//        for (int contador = 0; contador < charM.length; contador++) {
//            for (int cont = 0; cont < charM[contador].length; cont++) {
//                if (charM[contador][cont] == ' '){
//                    System.out.println(charM[contador][cont] + "verif");
//                    verif = true;
//                    break;
//                }
//            }
//        }
        
        return verif;        
    }//fin funcion verificar posicion valida
    
    public static void imprimirI (int matriz [][]) {
        for (int contador = 0; contador < matriz.length; contador++) {
            for (int cont = 0; cont < matriz[contador].length; cont++) {
                System.out.print(matriz[contador][cont]);
                System.out.print("  ");
                if (matriz[contador][cont] < 10){
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }//fin funcion imprimir matriz tipo int
    
    public static void encontrarPuntosSilla(int matriz[][]){
        int menor = 101;
        int indiceX = 0;
        int indiceY = 0;
        int tnoc = 0;
        boolean mayor = false;
            for (int contador = 0; contador < matriz.length; contador++) {
                for (int cont = 0; cont < matriz.length; cont++){
                    if (matriz[contador][cont] < menor){
                        menor = matriz[contador][cont];
                        indiceX = cont;
                        indiceY = contador;
                    }
                mayor = Mayor(indiceX,menor,matriz); 
                }
            if (mayor == true){
                tnoc ++;
                indiceX = 0;
                indiceY = 0;
                System.out.println("Punto de silla en matriz [" + indiceX + "," + indiceY + "]: " + menor);
                menor = 101;
            break;
            }
        }

        if(tnoc == 0){
            System.out.println("No hay puntos de silla");
        }
    }
    
    public static boolean Mayor(int indiceX, int menor, int matriz[][]){
        boolean mayor = false;
        int numM = 0;
        for (int contador = 0; contador < matriz.length; contador++) { 
            if(matriz[contador][indiceX] > numM){
                   numM = matriz[contador][indiceX];
            }
        }
        if (menor == numM){
            mayor = true;
            numM = 0;
        }
        return mayor;
    }
    
    public static void imprimir (char matriz [][]) {
        for (int contador = 0; contador < matriz.length; contador++) {
            System.out.print("[");
            for (int cont = 0; cont < matriz[contador].length; cont++) {
                System.out.print(matriz[contador][cont]);
                if (cont < matriz.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println("");
        }
    }//fin funcion imprimir matriz tipo char
    
    public static int [][] generarIntMatrizAleatoria(int size){
    int temporal [][] = new int [size][size];
        for (int contador = 0; contador < temporal.length; contador++) {
            for (int cont = 0; cont < temporal.length; cont++) {
                temporal [contador][cont] = rand.nextInt(0,100);
            }
        
        }
    return temporal;
    }
    public static boolean verificarVictoria (char charM [][]){
    boolean victoriaU = false;
        if (charM[0][0] == 'X' && charM[1][0] == 'X' && charM[2][0] == 'X'){
            victoriaU = true;
        }//victoria horizontal fila 0
        
        if (charM[0][1] == 'X' && charM[1][1] == 'X' && charM[2][1] == 'X'){
            victoriaU = true;
        }//victoria horizontal fila 1
        
        if (charM[0][2] == 'X' && charM[1][2] == 'X' && charM[2][2] == 'X'){
            victoriaU = true;
        }//victoria horizontal fila 2
        
        if (charM[0][0] == 'X' && charM[0][1] == 'X' && charM[0][2] == 'X'){
            victoriaU = true;
        }//victoria vertical columna 0
        
        if (charM[1][0] == 'X' && charM[1][1] == 'X' && charM[1][2] == 'X'){
            victoriaU = true;
        }//victoria vertical columna 1
        
        if (charM[2][0] == 'X' && charM[2][1] == 'X' && charM[2][2] == 'X'){
            victoriaU = true;
        }//victoria vertical columna 0
        
        if (charM[0][0] == 'X' && charM[1][1] == 'X' && charM[2][2] == 'X'){
            victoriaU = true;
        }//victoria vertical columna 0
        
        if (charM[2][0] == 'X' && charM[1][1] == 'X' && charM[0][2] == 'X'){
            victoriaU = true;
        }//victoria vertical columna 0
        return victoriaU;
    }
    public static boolean victoriaM (char charM [][]){
    boolean victoriaM = false;
    
        if (charM[0][0] == '0' && charM[1][0] == '0' && charM[2][0] == '0'){
            victoriaM = true;
        }//victoria horizontal fila 0
        
        if (charM[0][1] == '0' && charM[1][1] == '0' && charM[2][1] == '0'){
            victoriaM = true;
        }//victoria horizontal fila 1
        
        if (charM[0][2] == '0' && charM[1][2] == '0' && charM[2][2] == '0'){
            victoriaM = true;
        }//victoria horizontal fila 2
        
        if (charM[0][0] == '0' && charM[0][1] == '0' && charM[0][2] == '0'){
            victoriaM = true;
        }//victoria vertical columna 0
        
        if (charM[1][0] == '0' && charM[1][1] == '0' && charM[1][2] == '0'){
            victoriaM = true;
        }//victoria vertical columna 1
        
        if (charM[2][0] == '0' && charM[2][1] == '0' && charM[2][2] == '0'){
            victoriaM = true;
        }//victoria vertical columna 0
        
        if (charM[0][0] == '0' && charM[1][1] == '0' && charM[2][2] == '0'){
            victoriaM = true;
        }//victoria vertical columna 0
        
        if (charM[2][0] == '0' && charM[1][1] == '0' && charM[0][2] == '0'){
            victoriaM = true;
        }//victoria vertical columna 0
        
    return victoriaM;
    }
    
}
