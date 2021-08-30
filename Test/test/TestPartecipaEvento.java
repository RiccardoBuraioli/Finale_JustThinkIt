package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.PartecipaEventoController;

public class TestPartecipaEvento {
	PartecipaEventoController partecipaEv = PartecipaEventoController.getInstance();
	
	public TestPartecipaEvento() {
		
	}
	@Test
	public void testParte() {
		this.partecipaEv.setDataController(1,3);
		assertEquals(false, this.partecipaEv.partecipaEvento((float) 23.54));
	}
}
