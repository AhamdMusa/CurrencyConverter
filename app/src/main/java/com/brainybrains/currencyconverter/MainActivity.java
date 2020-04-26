package com.brainybrains.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;
import java.util.List;

import vas.com.currencyconverter.CurrencyConverter;

public class MainActivity extends AppCompatActivity implements Popup.PopupListener {

    private EditText editText;
    private TextView textViewUp,textViewDw;
    private ImageView floatingActionButton,miniflag;
    List<Currency> clist = CurrencyConverter.getCurrencyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edittext);
        textViewUp=findViewById(R.id.textViewUp);
        textViewDw=findViewById(R.id.textViewDw);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        miniflag=findViewById(R.id.miniflag);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event == null || !event.isShiftPressed()) {
                        double value = Double.parseDouble(editText.getText().toString());
                        CurrencyConverter.calculate(value, "USD", "BDT", new CurrencyConverter.Callback() {
                            @Override
                            public void onValueCalculated(Double value, Exception e) {
                                if (e != null) {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }else{
                                    //Do someting with value.
                                    textViewUp.setText(CurrencyConverter.formatCurrencyValue("BDT",value));
                                }
                            }
                        });
                        CurrencyConverter.calculate(value, "USD", "EUR", new CurrencyConverter.Callback() {
                            @Override
                            public void onValueCalculated(Double value, Exception e) {
                                if (e != null) {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }else{
                                    textViewDw.setText(CurrencyConverter.formatCurrencyValue("EUR",value));
                                }
                            }
                        });
                        return true; // consume.
                    }
                }
                return false;
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        textViewUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        miniflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        textViewDw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        Popup popup = new Popup();
        popup.show(getSupportFragmentManager(), "example dialog");
    }


//    @Override
//    public void applyTexts(String username, String password) {
//
//    }
}
