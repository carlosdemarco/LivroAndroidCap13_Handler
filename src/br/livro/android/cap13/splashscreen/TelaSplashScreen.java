package br.livro.android.cap13.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import br.livro.android.cap13.Menu;
import br.livro.android.cap13.R;

/**
 * Exemplo de Splash Screen
 * 
 * @author ricardo
 *
 */
public class TelaSplashScreen extends Activity {

	private static final int FECHAR_SPLASH = 1;

	//3 segundos
	private final int DELAY = 3000;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.layout_splash);

		Message msg = new Message();
		msg.what = FECHAR_SPLASH;
		handler.sendMessageDelayed(msg, DELAY);
	}

	/** Handler utilizado para atualizar a view **/
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			//o msg.what permite identificar a mensagem
			switch (msg.what) {
				case FECHAR_SPLASH:
					// Inicia a Activity do Menu: MenuHandler
					startActivity(new Intent(TelaSplashScreen.this, Menu.class));

					Toast.makeText(TelaSplashScreen.this, "Fim Splash", Toast.LENGTH_SHORT).show();
					
					finish();
	
				default:
					break;
			}
		}
	};
}
