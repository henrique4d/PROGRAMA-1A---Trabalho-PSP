import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;



class VerificaImpedimento{
    public Vector <Integer> atacantes = new Vector<>();
    public Vector <Integer> defensores = new Vector<>();
    public void addAtacante(int dist){
        atacantes.add(dist);
    }
    public void addDefensor(int dist){
        defensores.add(dist);
    }
    public Integer getSegundoDefensor(){
        Collections.sort(defensores);
        return defensores.get(1);
    }
    public Integer getPrimeiroAtacante(){
        Collections.sort(atacantes);
        return atacantes.get(0);
    }
    public boolean hasImpedimento(){
        if (getSegundoDefensor() > getPrimeiroAtacante()) return true;
        else return false;
    }
    public void resetData(){
        atacantes.clear();
        defensores.clear();
    }
    public boolean getData(){
        Scanner sc = new Scanner(System.in);
        Integer numAtacantes = sc.nextInt();
        Integer numDefensores = sc.nextInt();
        
        if (numAtacantes == 0 && numDefensores == 0) {
        	sc.close();
        	return false;
        }
        for (int i =0; i<numAtacantes; i++){
            Integer dist = sc.nextInt();
            addAtacante(dist);
        }
        for (int i =0; i<numDefensores; i++){
            Integer dist = sc.nextInt();
            addDefensor(dist);
        }
        sc.close();
        return true;
        
    }
    public void solve(){
        if (hasImpedimento()) System.out.println("Y");
        else System.out.println("N");
    }

    public static void main(String[] args){
        VerificaImpedimento verificacao = new VerificaImpedimento();
        while(verificacao.getData()){
            verificacao.solve();
            verificacao.resetData();
        }
    }

}