package br.livro.android.cap13.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import br.livro.android.cap13.Menu;
import br.livro.android.cap13.R;

/**
 * Exemplo de Splash Screen
 * 
 * @author ricardo
 * 
 */
public class TelaSplashScreenRunnable extends Activity implements Runnable {
	// 3 segundos
	private final int DELAY = 3000;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// Exibe o layout com a imagem...
		setContentView(R.layout.layout_splash);

		Toast.makeText(this, "Aguarde o carregamento da aplicação...", Toast.LENGTH_SHORT).show();

		// Solicita para o Handler executar o Runnable (this), fechando a Splash
		// Screen depois de alguns segundos
		Handler h = new Handler();
		h.postDelayed(this, DELAY);
	}

	public void run() {
		// Abre o menu principal
		startActivity(new Intent(this, Menu.class));

		// Finaliza esta activity
		finish();
	}
}
