package br.livro.android.cap13;

import android.widget.TextView;

public class SomaSimples extends ExemploBaseSoma {

	protected void somar(int i1, int i2) {
		int soma = i1 + i2;
		
		TextView somaText = (TextView) findViewById(R.id.labelSoma);
		somaText.setText(String.valueOf("Soma: " + soma));
	}
}
