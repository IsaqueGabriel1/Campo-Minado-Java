package br.com.isaquedev.cm.modelo;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.isaquedev.cm.excecao.ExplosaoException;


public class CampoTeste {
	
	private Campo campo;
	
	//para cada teste execute esta função
	@BeforeEach 
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealEsquerda() {
		Campo vizinho = new Campo(3,2);
		
		boolean res = campo.adicionarVizinho(vizinho);
	
		assertTrue(res);
	}
	
	@Test
	void testeVizinhoDireita() {
		Campo vizinho = new Campo(3,4);
		
		boolean res = campo.adicionarVizinho(vizinho);
	
		assertTrue(res);
	}
	
	@Test
	void testeVizinhoEmCima() {
		Campo vizinho = new Campo(2,3);
		
		boolean res = campo.adicionarVizinho(vizinho);
	
		assertTrue(res);
	}
	
	@Test
	void testeVizinhoEmEmBaixo() {
		Campo vizinho = new Campo(4,3);
		
		boolean res = campo.adicionarVizinho(vizinho);
	
		assertTrue(res);
	}
	
	@Test
	void testeVizinhorealD2() {
		Campo vizinho = new Campo(2,2);
		
		boolean res = campo.adicionarVizinho(vizinho);
	
		assertTrue(res);
	}
	
	@Test
	void testeNaoVizinhorealD2() {
		Campo vizinho = new Campo(1,1);
		
		boolean res = campo.adicionarVizinho(vizinho);
	
		assertFalse(res);
	}
	
	@Test
	void testeAlternarMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeValorPadraoAtributoDuasMarcado() {
		//Marcado
		campo.alternarMarcacao();
		//Desmarcado
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void abrirCampoNaoMinado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void abrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirCampoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirCampoMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	void vizinhacaNaoSegura() {
		//campo.minar();
		assertFalse(campo.vizinhancaSegura());
	}
	
	@Test
	void testeAbrirComVizinho() {
		Campo campo22 = new Campo(2,2);
		Campo campo11 = new Campo(1,1);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhoMinado() {
		Campo campo22 = new Campo(2,2);
		Campo campo11 = new Campo(1,1);
		
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && !campo11.isAberto());
	}
}
