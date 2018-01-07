package fatcat.pizzagps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class NeedleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needle);

        final Thread imgRot = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<360;i+=30){
                    rotateImage(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
        });

        imgRot.start();
    }



    private void rotateImage(double degrees){
        ImageView img = findViewById(R.id.arrow_view);
        float dg = (float) degrees;
        img.setRotation(dg);
    }





}
