package br.livro.android.cap13;

import android.widget.TextView;

/**
 * Implementa a soma em uma Thread separada, mas isto da erro.
 * 
 * Ver exemplo do handler para corrigir isto
 * 
 * @author ricardo
 *
 */
public class SomaThread extends ExemploBaseSoma {
	@Override
	protected void somar(final int n1, final int n2) {
		new Thread(){
			public void run() {
				int soma = n1 + n2;
				TextView t = (TextView) findViewById(R.id.labelSoma);
				t.setText(String.valueOf("Soma: " + soma));
			}
		}.start();
	}
}
