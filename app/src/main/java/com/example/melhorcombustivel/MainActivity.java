package com.example.melhorcombustivel;

import android.graphics.drawable.Drawable;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private double percent = 1000.00;
    private TextView gasolinaTextView;
    private TextView valorGasolinaTextView;
    private TextView alcoolTextView;
    private TextView valorAlcoolTextView;
    private TextView melhorCombustivelTextView;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasolinaTextView = (TextView) findViewById(R.id.gasolinaTextView);
        valorGasolinaTextView = (TextView) findViewById(R.id.valorGasolinaTextView);

        alcoolTextView = (TextView) findViewById(R.id.alcoolTextView);
        valorAlcoolTextView = (TextView) findViewById(R.id.valorAlcoolTextView);

        melhorCombustivelTextView = (TextView) findViewById(R.id.melhorCombustivelTextView);

        SeekBar gasolinaSeekBar = (SeekBar) findViewById(R.id.gasolinaSeekBar);
        gasolinaSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        SeekBar alcoolSeekBar = (SeekBar) findViewById(R.id.alcoolSeekBar);
        alcoolSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        imagem = (ImageView) findViewById(R.id.melhorCombustivelImageView);

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            float novoValor = ((float)progress /1000);
            double gasolina=0.0, alcool=0.0;
            gasolina = Double.parseDouble(valorGasolinaTextView.getText().toString());
            alcool = Double.parseDouble(valorAlcoolTextView.getText().toString());
            if (((alcool/ gasolina)>=0.7)){
                Drawable drawableGasolina = getResources().getDrawable(R.drawable.gasolina);
                String stringGasolina = getResources().getString(R.string.gasolina_txt);
                melhorCombustivelTextView.setText(stringGasolina);
                imagem.setImageDrawable(drawableGasolina);
            }
            else {
                String stringAlcool = getResources().getString(R.string.alcool_txt);
                Drawable drawableAlcool = getResources().getDrawable(R.drawable.alcool);
                melhorCombustivelTextView.setText(stringAlcool);
                imagem.setImageDrawable(drawableAlcool);
            }

            if (seekBar == findViewById(R.id.gasolinaSeekBar)){
                valorGasolinaTextView.setText(Float.toString(novoValor));

            }
            if (seekBar == findViewById(R.id.alcoolSeekBar)){
                valorAlcoolTextView.setText(Float.toString(novoValor));
            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
