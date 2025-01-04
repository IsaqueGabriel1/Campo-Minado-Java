package br.com.isaquedev.cm;

import br.com.isaquedev.cm.modelo.Tabuleiro;
import br.com.isaquedev.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
	}
}
