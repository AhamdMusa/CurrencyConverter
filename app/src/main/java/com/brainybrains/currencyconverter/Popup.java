package com.brainybrains.currencyconverter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Popup extends AppCompatDialogFragment {
    private PopupListener listener;
    private ImageView australia,brazil,canada,china,france,germany,india,indonesia,
            italy,japan,mexico,netherlands,russia,saudiarabia,southkorea,spain,switzerland,
            turkey,unitedkingdom,unitedstates;
    private String countryCode;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.popup, null);

        australia=view.findViewById(R.id.australia);
        brazil=view.findViewById(R.id.brazil);
        canada=view.findViewById(R.id.canada);
        china=view.findViewById(R.id.china);
        france=view.findViewById(R.id.france);
        germany=view.findViewById(R.id.germany);
        india=view.findViewById(R.id.india);
        indonesia=view.findViewById(R.id.indonesia);
        italy=view.findViewById(R.id.italy);
        japan=view.findViewById(R.id.japan);
        mexico=view.findViewById(R.id.mexico);
        netherlands=view.findViewById(R.id.netherlands);
        russia=view.findViewById(R.id.russia);
        saudiarabia=view.findViewById(R.id.saudiarabia);
        southkorea=view.findViewById(R.id.southkorea);
        spain=view.findViewById(R.id.spain);
        switzerland=view.findViewById(R.id.switzerland);
        turkey=view.findViewById(R.id.turkey);
        unitedkingdom=view.findViewById(R.id.unitedkingdom);
        unitedstates=view.findViewById(R.id.unitedstates);
        onclicks();


        builder.setView(view);
//.......................Problems are here...........................//

        return builder.create();
    }

    private void onclicks() {
        australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="AUD";
                listener.applyTexts(countryCode);
            }
        }); brazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="BRL";
                listener.applyTexts(countryCode);
            }
        }); canada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="CAD";
                listener.applyTexts(countryCode);
            }
        }); china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="CNY";
                listener.applyTexts(countryCode);
            }
        }); france.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="EUR";
                listener.applyTexts(countryCode);
            }
        }); germany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="EUR";
                listener.applyTexts(countryCode);
            }
        }); india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="INR";
                listener.applyTexts(countryCode);
            }
        }); indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="IDR";
                listener.applyTexts(countryCode);
            }
        }); italy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="EUR";
                listener.applyTexts(countryCode);
            }
        }); japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="JPY";
                listener.applyTexts(countryCode);
            }
        }); mexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="MXN";
                listener.applyTexts(countryCode);
            }
        }); netherlands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="EUR";
                listener.applyTexts(countryCode);
            }
        }); russia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="RUR";
                listener.applyTexts(countryCode);
            }
        }); saudiarabia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="SAR";
                listener.applyTexts(countryCode);
            }
        }); southkorea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="WON";
                listener.applyTexts(countryCode);
            }
        }); spain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="EUR";
                listener.applyTexts(countryCode);
            }
        }); switzerland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="SZL";
                listener.applyTexts(countryCode);
            }
        }); turkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="TRY";
                listener.applyTexts(countryCode);
            }
        }); unitedkingdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="GBP";
                listener.applyTexts(countryCode);
            }
        }); unitedstates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryCode="USS";
                listener.applyTexts(countryCode);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (PopupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface PopupListener {
        void applyTexts(String countryCode);
    }
}
