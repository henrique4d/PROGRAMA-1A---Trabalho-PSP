import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VerificaImpedimentoTeste{
    VerificaImpedimento verificacao;
   
    
    @Before
    public void init(){
        verificacao = new VerificaImpedimento();
    }
    @Test
    public void testeAtacante() {
    	verificacao.addAtacante(5);
    	verificacao.addAtacante(10);
    	int result = verificacao.getPrimeiroAtacante();
    	assertEquals(result,5);
    }
    @Test
    public void testeDefensor() {
    	verificacao.addDefensor(5);
    	verificacao.addDefensor(10);
    	int result = verificacao.getSegundoDefensor();
    	assertEquals(result,10);
    }
    @Test
    public void testeImpedimento() {
    	verificacao.addAtacante(5);
    	verificacao.addAtacante(10);
    	verificacao.addDefensor(5);
    	verificacao.addDefensor(10);
    	assertTrue(verificacao.hasImpedimento());
    }
    @Test
    public void testeSemImpedimento() {
    	verificacao.addAtacante(5);
    	verificacao.addAtacante(10);
    	verificacao.addDefensor(2);
    	verificacao.addDefensor(5);	
    	assertFalse(verificacao.hasImpedimento());
    }
    @Test
    public void testeResetData() {
    	verificacao.addAtacante(5);
    	verificacao.addAtacante(10);
    	verificacao.resetData();
    	verificacao.addAtacante(12);
    	int result = verificacao.getPrimeiroAtacante();
    	assertEquals(result,12);
    }
    @Test
    public void getData() {
    	System.setIn(new ByteArrayInputStream("2 2\n 1 2\n 3 4".getBytes()));
    	boolean result = verificacao.getData();
    	assertTrue(result);
    }
    @Test
    public void getDataFinal() {
    	System.setIn(new ByteArrayInputStream("0 0".getBytes()));
    	boolean result = verificacao.getData();
    	assertFalse(result);
    }
    @Test
    public void testeSolveTrue() {
    	ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(outputStreamCaptor));
    	verificacao.addAtacante(5);
    	verificacao.addAtacante(10);
    	verificacao.addDefensor(5);
    	verificacao.addDefensor(10);
    	verificacao.solve();
    	assertEquals("Y",outputStreamCaptor.toString().trim());
    }
    @Test
    public void testeSolveFalse() {
    	ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(outputStreamCaptor));
    	verificacao.addAtacante(5);
    	verificacao.addAtacante(10);
    	verificacao.addDefensor(1);
    	verificacao.addDefensor(2);
    	verificacao.solve();
    	assertEquals("N",outputStreamCaptor.toString().trim());
    }
    
}