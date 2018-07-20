package fatcat.pizzagps.GUI;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fatcat.pizzagps.PizzeriaFinder;
import fatcat.pizzagps.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
    }

    public void findPizzeriaButton(View view){
        if(permissionsNotEnabled()){
            promptUserForPermission();
        }else{
            Intent needle = new Intent(this,NeedleActivity.class);
            startActivity(needle);
        }
    }

    private boolean permissionsNotEnabled(){

            boolean gps = ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
            boolean network = ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED;

            boolean internet = ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED;

        return ! gps || ! network || ! internet;
    }

    private void promptUserForPermission(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Appen måste ha behörighet för att använda GPS & internet.\n\n" +
                "Aktivera dessa och försök igen.");
        dlgAlert.setTitle("Saknar behörighet!");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }


}
