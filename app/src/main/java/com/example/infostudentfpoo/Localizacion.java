package com.example.infostudentfpoo;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Localizacion implements LocationListener {


    MainActivity mainActivity;
    TextView tvmensaje;

    public MainActivity getMainActivity(){
        return mainActivity;

    }

    public void setMainActivity(MainActivity mainActivity, TextView tvmensaje) {
        this.mainActivity = mainActivity;

        this.tvmensaje = tvmensaje;

    }

    @Override
    public void onLocationChanged(Location location) {
        // metodo se ejecuta cuando el GPs recibe nuevas coordenadas
        String Texto = "Mi ubicación es: /n"
                + "Latitud = " + location.getLatitude() + "/n"
                + "Longitud = " + location.getLongitude();

        tvmensaje.setText(Texto);
        mapa(location.getLatitude(), location.getLongitude());

    }

    public void mapa (double lat, double lon){
        // Fragmento del Mapa
        FragmentMaps fragment = new FragmentMaps();

        Bundle bundle = new Bundle();
        bundle.putDouble("lat", new Double(lat));
        bundle.putDouble("lon", new Double(lon));
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getMainActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, fragment, null);
        fragmentTransaction.commit();




    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d("debug","LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug","LoactionProvider.TEMPORARILY_UNAVAILABLE");
                break;

        }

    }

    @Override
    public void onProviderEnabled(String provider) {
        tvmensaje.setText("GPS activado");

    }

    @Override
    public void onProviderDisabled(String provider) {
        tvmensaje.setText("GPS desactivado");

    }
}
