package com.example.menucontextualvarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtInicio;
    ImageView imgAguila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInicio = findViewById(R.id.txtInicio);
        imgAguila = findViewById(R.id.imgAguila);

        registerForContextMenu(txtInicio);
        registerForContextMenu(imgAguila);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id = v.getId();
        if (id == txtInicio.getId()) {
            getMenuInflater().inflate(R.menu.menu_contextual_txt, menu);
        } else if (id == imgAguila.getId()) {
            getMenuInflater().inflate(R.menu.menu_contextual_img, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1 || id == R.id.item2 || id == R.id.item3){
            Toast.makeText(MainActivity.this,"Etiqueta: "+item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.itemA || id == R.id.itemB) {
            Toast.makeText(MainActivity.this,"Imagen: "+item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        } else{
            return false;
        }
    }
}
