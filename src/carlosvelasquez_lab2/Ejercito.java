package carlosvelasquez_lab2;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Ejercito implements Serializable{
    static final long SerialVersionUID = 777L;
    
    String nombreEjercito;
    String[] campos, armas;
    String[][] listaSoldados;
    int indiceEdad, indiceResistencia, indiceArma, edadMin, num = 0, indicePoder;
    int[] armasPoder;
    ArrayList<String[]> listaSoldadosAL = new ArrayList(), listaMuertos = new ArrayList<String[]>();
    
    public Ejercito(int tipo){
        switch (tipo){
            case 1:
                campos = new String[]{"Num", "Nombre", "ID", "Edad", "Rango", "Resistencia", "Tipo de Arma", "Poder de Fuego"};
                armas = new String[]{"AK-47", "Revolver Navant", "RPG-7"};
                armasPoder = new int[]{27, 13, 57};
                nombreEjercito = "Rusos";
                indiceEdad = 3;
                indiceResistencia = 5;
                indiceArma = 6;
                indicePoder = 7;
                edadMin = 18;
                break;
            case 2:
                campos = new String[]{"Num", "Alias", "Edad", "Casta", "Resistencia", "Tipo de Arma", "Poder de Fuego"};
                armas = new String[]{"Subfusíl MP40", "Ametralladora MG42", "Pistola Walther"};
                armasPoder = new int[]{25, 32, 11};
                nombreEjercito = "Alemanes";
                indiceEdad = 2;
                indiceResistencia = 4;
                indiceArma = 5;
                indicePoder = 6;
                edadMin = 0;
                break;
            case 3:
                campos = new String[]{"Num", "Apodo", "No. Cuenta", "Edad", "Resistencia", "Grado Académico", "Tipo de Arma", "Poder de Fuego"};
                armas = new String[]{"Disco Duro", "Control de Wii", "Laptop"};
                armasPoder = new int[]{23, 47, 76};
                nombreEjercito = "Alumnos";
                indiceEdad = 3;
                indiceResistencia = 4;
                indiceArma = 6;
                indicePoder = 7;
                edadMin = 16;
                break;
        }
    }
    
    String getNombreEjercito(){
        return nombreEjercito;
    }
    
    String[] getCampos(){
        return campos;
    }
    
    String[][] getListaSoldados(){
        String[][] retornarLista = new String[listaSoldadosAL.size()][campos.length];
        
        for (int i = 0; i < listaSoldadosAL.size(); i++) {
            retornarLista[i] = listaSoldadosAL.get(i).clone();
        }
        
        return retornarLista;
    }
    
    void nuevoSoldado(String[] infoSoldado){
        listaSoldadosAL.add(infoSoldado);
        num ++;
    }
    
    int getEdadMin(){
        return edadMin;
    }
    
    int getIndiceEdad(){
        return indiceEdad;
    }
    
    int getIndiceArma(){
        return indiceArma;
    }
    
    String[] getArmas(){
        return armas;
    }
    
    int[] getArmasPoder(){
        return armasPoder;
    }
    
    int getIndiceResistencia(){
        return indiceResistencia;
    }
    
    int getIndicePoder(){
        return indicePoder;
    }
    
    int getNum(){
        return num;
    }
    
    ArrayList<String[]> getListaSoldadosAL(){
        return listaSoldadosAL;
    }
    
    void setListaSoldados(ArrayList<String[]> listaNueva){
        listaSoldadosAL = listaNueva;
    }
    
    boolean fueDerrotado(){
        num = listaSoldadosAL.size() - 1;
        if (num < 0)
            return true;
        return false;
    }
    
    void removerMuertos(){
        for (int i = 0; i < listaSoldadosAL.size(); i++) {
            int res = Integer.parseInt(listaSoldadosAL.get(i)[this.getIndiceResistencia()]);
            if (res < 1) {
                listaMuertos.add(listaSoldadosAL.get(i));
                listaSoldadosAL.remove(i);
            }
        }
    }
    
    String imprimirMuertos(){
        String s = ("Soldados " + nombreEjercito + " caídos en batalla:\n");
        
        for (int i = 0; i < listaMuertos.size(); i++) {
            for (int j = 0; j < listaMuertos.get(i).length; j++) {
                s += (" | " + listaMuertos.get(i)[j]);
            }
            s += (" | \n");
        }
        
        return s;
        //JOptionPane.showMessageDialog(null, s, s, num, icon);
    }

    void modificarSoldado(String[] camposNuevos, int modSel) {
        listaSoldadosAL.remove(modSel);
        listaSoldadosAL.add(camposNuevos);
    }
    
    void modificarSoldado(String[] camposNuevos, String modSelString) {
        int modSel = Integer.parseInt(modSelString);
        listaSoldadosAL.remove(modSel-1);
        listaSoldadosAL.add(camposNuevos);
    }
    
    void eliminarSoldado(String modSelString) {
        int modSel = Integer.parseInt(modSelString);
        listaSoldadosAL.remove(modSel-1);
        num --;
    }

    void removerMuertos(int remSel) {
        listaSoldadosAL.remove(remSel-1);
    }

    @Override
    public String toString() {
        return nombreEjercito;
    }
    
    
}
