package br.livro.android.cap13;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Simples exemplo que utiliza um Handler para atualizar um texto da View
 * 
 * Ao clicar no botão, uma mensagem é enviada com delay de 3 seg.
 * 
 * O handler recebe a mensagem e atualiza o TextView
 * 
 * @author ricardo
 * 
 */
public class ExemploHandler extends Activity {
	protected static final int MENSAGEM_TESTE = 1;
	private Handler handler = new TesteHandler();

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.exemplo_handler);

		Button b = (Button) findViewById(R.id.btEnviar);
		b.setText("Atualizar o texto em 3 segundos");
		b.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				// Cria a mensagem com delay de 3 seg
				Message msg = new Message();
				msg.what = MENSAGEM_TESTE;
				// Envia a mensagem
				handler.sendMessageDelayed(msg, 3000);
			}
		});
	}

	/** Handler utilizado para receber a mensagem **/
	private class TesteHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			// O atributo msg.what permite identificar a mensagem
			switch (msg.what) {
			case MENSAGEM_TESTE:
				Toast.makeText(ExemploHandler.this, "A mensagem chegou!", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};
}
