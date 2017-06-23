package carlosvelasquez_lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class CarlosVelasquez_Lab2 {
    static Scanner entrada = new Scanner(System.in);
    static Ejercito rusos = new Ejercito(1);
    static Ejercito alemanes = new Ejercito(2);
    static Ejercito alumnos = new Ejercito(3);

    public static void main(String[] args) {
        System.out.println("Laboratorio 2 - Carlos Velásquez");
        
        do {
            menu();
        } while (true);
        
    }
    
    static void menu(){
        System.out.println("-   -   -   -   -   -   -   -   -   -   -   -   -");
        System.out.println("[1] Comenzar Programa");
        System.out.println("[2] Salir");
        System.out.println("");
        System.out.print("Ingrese el numero de la opción que desea: ");
        int sel = entrada.nextInt();
        System.out.println("-   -   -   -   -   -   -   -   -   -   -   -   -");
        
        switch(sel){
            case 1:
                intro();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Numero inválido, por favor intente de nuevo.");
                break;
        }
        
    }
    
    static void intro(){
        System.out.printf("En un intento por formatear una computadora,\n"
                + "los alumnos de programación II han desembocado una serie \n"
                + "de eventos sobrenaturales"
                + "que de alguna forma los llevarona\n"
                + "trás en el tiempo a los últimos meses de 1942 en\n"
                + "Rusia en donde se disputaba la famosa “Batalla de Stalingrado”.\n\n" +
"Ahora los 3 ejércitos pelearán arduamente entre ellos por el control de la ciudad soviética de Stalingrado.");
        System.out.println("\n\n");
        System.out.println("Este es el menú de preparación, donde podrá indicar a cada ejercito\n"
                + "la forma en la que se enfrentarán a los otros.");
        
        Ejercito ej = rusos;
        preparacion(ej);
    }
    
    static void preparacion(Ejercito ej){
        boolean rep;
        
        do{
            rep = true;
            System.out.println("-   -   -   -   -   -   -   -   -   -   -   -   -");
            System.out.println("EJÉRCITO ACTUAL - " + ej.getNombreEjercito());
            System.out.println("\n[1] Reclutar Soldados");
            System.out.println("[2] Listar Soldados");
            System.out.println("[3] Cambiar de Ejército");
            System.out.println("[4] Modificar Soldado");
            System.out.println("[5] Dar de alta a Soldado");
            System.out.println("[6] SIMULAR BATALLAS");
            System.out.print("\n¿Que desea hacer? - ");
            int ejSel = entrada.nextInt();
            System.out.println("-   -   -   -   -   -   -   -   -   -   -   -   -");

            switch (ejSel){
                case 1:
                    boolean continuar;
                    String[] camposNuevos;
                    
                    do{
                        boolean selRPG = false;
                        continuar = false;
                        String[] campos = ej.getCampos();
                        camposNuevos = new String[campos.length];
                        int poderFuego;

                        for (int i = 0; i < campos.length - 1; i++) {
                            entrada = new Scanner(System.in);
                            if (i != ej.getIndiceResistencia() && i != 0) {
                                System.out.print("Ingresar " + campos[i]);
                                if (i == ej.getIndiceArma()) {
                                    System.out.println("\nArmamento Disponible:\n");

                                    String[] armas = ej.getArmas();
                                    int[] armasPoder = ej.getArmasPoder();

                                    for (int j = 0; j < armas.length; j++) {
                                        System.out.println("[" + (j+1) + "] " + armas[j] + " | Poder de Fuego: " + armasPoder[j]);
                                    }
                                    System.out.print("Seleccione un arma: ");
                                    int armaSel = entrada.nextInt();
                                    
                                    if ("RPG-7".equals(armas[2]) && armaSel == 3) {
                                        selRPG = true;
                                    }
                                    
                                    camposNuevos[i] = armas[armaSel-1];
                                    camposNuevos[i + 1] = Integer.toString(armasPoder[armaSel - 1]);
                                }else{
                                    System.out.print(": ");
                                    camposNuevos[i] = entrada.nextLine();
                                }
                            }else if (i == 0){
                                camposNuevos[i] = Integer.toString(ej.getNum() + 1);
                                System.out.println("Reclutando el soldado numero " + (ej.getNum() + 1) + ".");
                            }else{
                                System.out.println("\nEl soldado tendrá una resistencia de " + (8*(Integer.parseInt((camposNuevos[(ej.getIndiceEdad())])))));
                                camposNuevos[i] = Integer.toString((8*(Integer.parseInt((camposNuevos[(ej.getIndiceEdad())])))));
                                System.out.println("");
                            }
                        }
                        
                        if (selRPG == true && (25 < Integer.parseInt(camposNuevos[ej.getIndiceEdad()]))) {
                            continuar = true;
                        }else if(selRPG == false && (Integer.parseInt(camposNuevos[ej.getIndiceEdad()]) > ej.getEdadMin())){
                            continuar = true;
                        }
                        else{
                            System.out.println("[ERROR] El soldado no cumple los requerimientos de edad.");
                        }
                        
                        if (continuar == true) {
                            System.out.println("Soldado reclutado exitosamente.");
                        }
                    }while(continuar == false);
                    ej.nuevoSoldado(camposNuevos);
                    break;
                case 2:
                    imprimirArreglo(ej.getCampos());
                    System.out.println("");
                    imprimirMatriz(ej.getListaSoldados());
                    break;
                case 3:
                    System.out.println("[1] Rusos");
                    System.out.println("[2] Alemanes");
                    System.out.println("[3] Alumnos");
                    System.out.print("\nIngrese el numero del ejército que desea: ");

                    switch(entrada.nextInt()){
                        case 1:
                            ej = rusos;
                            break;
                        case 2:
                            ej = alemanes;
                            break;
                        case 3:
                            ej = alumnos;
                            break;
                        default:
                            System.out.println("Numero de ejército inválido.");
                            break;

                    }
                    rep = true;
                    break;
                case 4:
                    boolean selRPG = false;
                    continuar = false;
                    String[] campos = ej.getCampos();
                    camposNuevos = new String[campos.length];
                    int poderFuego;
                        
                    System.out.print("Ingrese el numero del soldado que quiere modificar: ");
                    int modSel = entrada.nextInt();
                    
                    for (int i = 0; i < campos.length - 1; i++) {
                            entrada = new Scanner(System.in);
                            if (i != ej.getIndiceResistencia() && i != 0) {
                                System.out.print("Ingresar " + campos[i]);
                                if (i == ej.getIndiceArma()) {
                                    System.out.println("\nArmamento Disponible:\n");

                                    String[] armas = ej.getArmas();
                                    int[] armasPoder = ej.getArmasPoder();

                                    for (int j = 0; j < armas.length; j++) {
                                        System.out.println("[" + (j+1) + "] " + armas[j] + " | Poder de Fuego: " + armasPoder[j]);
                                    }
                                    System.out.print("Seleccione un arma: ");
                                    int armaSel = entrada.nextInt();
                                    
                                    if ("RPG-7".equals(armas[2]) && armaSel == 3) {
                                        selRPG = true;
                                    }
                                    
                                    camposNuevos[i] = armas[armaSel-1];
                                    camposNuevos[i + 1] = Integer.toString(armasPoder[armaSel - 1]);
                                }else{
                                    System.out.print(": ");
                                    camposNuevos[i] = entrada.nextLine();
                                }
                            }else if (i == 0){
                                camposNuevos[i] = Integer.toString(ej.getNum() + 1);
                                System.out.println("Reclutando el soldado numero " + (ej.getNum() + 1) + ".");
                            }else{
                                System.out.println("\nEl soldado tendrá una resistencia de " + (8*(Integer.parseInt((camposNuevos[(ej.getIndiceEdad())])))));
                                camposNuevos[i] = Integer.toString((8*(Integer.parseInt((camposNuevos[(ej.getIndiceEdad())])))));
                                System.out.println("");
                            }
                            
                            ej.modificarSoldado(camposNuevos, modSel);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el numero de soldado a despedir: ");
                    int remSel = entrada.nextInt();
                    ej.removerMuertos(remSel);
                    break;
                case 6:
                    batalla();
                    break;
                default:
                    System.out.println("Opción Invalida.");
                    preparacion(ej);
                    break;
            }
            
        }while (rep == true);
    }
    
    
    static void reclutar(Ejercito ej){
        String[] campos = ej.getCampos();
    }
    
    static void imprimirMatriz(Object[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(" | " + mat[i][j]);
            }
            System.out.println(" | ");
        }
    }
    
    static void imprimirArreglo(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" | " + arr[i]);
        }
        System.out.println(" | ");
    }
    
    static void batalla(){
        Ejercito ej[] = new Ejercito[3];
        int contDerrotados;
        
        for (int i = 0; true; i++) {
            switch (i){
                case 0:
                    ej[0]= rusos;
                    ej[1] = alemanes;
                    ej[2] = alumnos;
                    break;
                case 1:
                    ej[0]= alemanes;
                    ej[1] = rusos;
                    ej[2] = alumnos;
                    break;
                case 2:
                    ej[0]= alumnos;
                    ej[1] = rusos;
                    ej[2] = alemanes;
                    break;
            }
            
            contDerrotados = 0;
            
            for (int j = 1; j <= 2; j++) {
                if (ej[j].fueDerrotado() == false) {
                    int sobrecarga = (ej[0].getNum() + 1) - (ej[j].getNum() + 1), sobCont = 1;
                    ArrayList<String[]> listaSoldados = ej[0].getListaSoldadosAL();
                    ArrayList<String[]> listaSoldadosEnem = ej[j].getListaSoldadosAL();
                    int indRes = ej[j].getIndiceResistencia();
                    int indPod = ej[0].getIndicePoder();
                    int kUlt = 0;

                    System.out.println("¡Los " + ej[0].getNombreEjercito() + " están atacando a los " + ej[j].getNombreEjercito() + "!");

                    for (int k = 0; k < listaSoldados.size(); k++) {
                        if (k < listaSoldadosEnem.size()) {
                            listaSoldadosEnem.get(k)[indRes] = Integer.toString(Integer.parseInt(listaSoldadosEnem.get(k)[indRes]) - Integer.parseInt(listaSoldados.get(k)[indPod]));
                            kUlt = k;
                        }else{
                            if (sobrecarga > 0) {
                                listaSoldadosEnem.get(kUlt)[indRes] = Integer.toString(Integer.parseInt(listaSoldadosEnem.get(kUlt)[indRes]) - Integer.parseInt(listaSoldados.get(k)[indPod]));
                            }
                        }
                    }

                    ej[j].setListaSoldados(listaSoldadosEnem);
                    ej[j].removerMuertos();
                }else
                    contDerrotados ++;
            }
            
            if (contDerrotados > 1) {
                System.out.println("¡Los " + ej[0].getNombreEjercito() + " han ganado!");
                break;
            }
            
            if (i == 2) {
                i = 0;
            }
            
        }
        Ejercito[] ej2 = new Ejercito[3];
        
        ej2[0] = rusos;
        ej2[1] = alemanes;
        ej2[2] = alumnos;
        
        for (int i = 0; i < 3; i++) {
            ej2[i].imprimirMuertos();
        }
    }
}
