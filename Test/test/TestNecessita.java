package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.CreaNecessitaController;

public class TestNecessita {
	CreaNecessitaController creaNece = CreaNecessitaController.getInstace();
	

	
	@Test
	public void testNece() {
		this.creaNece.inizializza(17);
		assertEquals(true, this.creaNece.creaNecessita("Cibo", "Alta", "Voglio il latte"));
	
	}
	

}
