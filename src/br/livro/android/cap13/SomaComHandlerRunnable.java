package br.livro.android.cap13;

import android.os.Handler;
import android.widget.TextView;

public class SomaComHandlerRunnable extends ExemploBaseSoma  {

	protected static final int SOMAR = 1;

	//resultado da soma
	private int soma;

	@Override
	protected void somar(final int n1, final int n2) {

		/**
		 * Solicita para o Handler executar o Runnable (this),
		 * fechando a Splash Screen depois de alguns segundos
		 * */
		new Handler().post(new Runnable(){
			public void run() {
				soma = n1 + n2;

				//recebe a mensagem para atualizar a view
				TextView somaText = (TextView) findViewById(R.id.labelSoma);
				somaText.setText(String.valueOf("Soma: " + soma));			
			}
		});

		//o postDelayed é igual, mas o tempo informado em ms para executar
		//new Handler().postDelayed(r, delayMillis)
	}
}
