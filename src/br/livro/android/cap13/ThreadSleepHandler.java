package br.livro.android.cap13;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

/**
 * Este exemplo demonstra como utilizar um Handler para agendar tarefas com
 * delay...
 * 
 * Para evitar a utilização do Thread.sleep, conforme a recomendação do Android
 * 
 * @author ricardo
 * 
 */
public class ThreadSleepHandler extends Activity implements Runnable {

	private static final String CATEGORIA = "livro";
	private int count;
	private TextView text;
	private Handler handler;
	private boolean on;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		text = new TextView(this);
		setContentView(text);

		handler = new Handler();
		handler.post(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		on = true;
		Log.i(CATEGORIA, "onStart()");
	}

	public void run() {
		if (on) {
			count++;
			Log.i(CATEGORIA, "Handler.run() count: " + count);
			text.setText("Contador: " + count);
			// Repetir depois de 1 segundo
			handler.postDelayed(this, 1000);
		} else {
			Log.i(CATEGORIA, "Handler fim.");
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Encerrar as mensagens do handler
		Log.i(CATEGORIA, "onDestroy()");
		on = false;
	}
}
