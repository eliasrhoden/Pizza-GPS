package fatcat.pizzagps.GUI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


import fatcat.pizzagps.R;

/**
 * Created by Elias on 2018-01-18.
 */

public class UserMsgBox{
    public static void showMsgBox_OK(String title,String msg, Context cxt){
        AlertDialog alertDialog = new AlertDialog.Builder(cxt).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
