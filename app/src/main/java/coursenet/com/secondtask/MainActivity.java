package coursenet.com.secondtask;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.menuHome){

        } else if (item.getItemId()==R.id.menuAbout){

        } else if (item.getItemId()==R.id.menuLogout){

            Intent bb = new Intent(getApplicationContext(), secondActivity.class);
            startActivity(bb);

        } else if (item.getItemId()==R.id.menuExit){

            AlertDialog.Builder bdn = new AlertDialog.Builder(MainActivity.this);

            bdn.setMessage("Yakin Ngga?");

            bdn.setPositiveButton("Yakin Dong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
               finishAffinity();
                }
            });

            bdn.setNegativeButton("Ngga Deh", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            bdn.create().show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showMessage(View view) {
        //INI DIJALANKAN PAS DIKLIK
        /* BEDANYA..
        INI BISA DI ENTER PESANNYA */

        //1. ambil edittext dari xml nya
        EditText t1 = (EditText) findViewById(R.id.t1);
        EditText t2 = (EditText) findViewById(R.id.t2);

        //2.ambil isi dari t1 dan t2
        String email = t1.getText().toString();
        String password = t2.getText().toString();

        //3.cek emailnya kosong atau tidak
        if (email.length() == 0)
        {
            Toast.makeText(getApplicationContext(), R.string.Email_is_required, Toast.LENGTH_LONG).show();
            return;
        }

        if (password.length()==0)
        {
            t2.setError(getString(R.string.password_is_required));
            return;
        }

        Toast.makeText(getApplicationContext(),
                R.string.hello_world, Toast.LENGTH_LONG).show();
    }

    public void camera (View view){
        AlertDialog.Builder dev = new AlertDialog.Builder(MainActivity.this);

        dev.setMessage("Open Camera?");

        dev.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           Intent tr = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
           startActivityForResult(tr, 25);
            }
        });

        dev.setNegativeButton("Galeri", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           Toast.makeText(getApplicationContext(), "Fitur Belum Dapat Digunakan", Toast.LENGTH_LONG).show();
            }
        });

        dev.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==25);
        if (resultCode==RESULT_OK);

        ImageView gambar = (ImageView) findViewById(R.id.gambar);
        Bitmap img = (Bitmap) data.getExtras().get("data");

        gambar.setImageBitmap(img);
    }
}

