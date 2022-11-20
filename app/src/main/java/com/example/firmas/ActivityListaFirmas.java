package com.example.firmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaFirmas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter reviewadapter;
    ArrayList<Firmas> lista;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_firmas);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reviewadapter = new Adapter(ObtenerFirma());
        recyclerView.setAdapter(reviewadapter);

    }

    private List<Firmas> ObtenerFirma() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase,null,1);
        SQLiteDatabase db= conexion.getReadableDatabase();
        Firmas firma;
        lista= new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.Tabla, null);

        while(cursor.moveToNext())
        {
            firma = new Firmas();
            firma.setId(cursor.getInt(0));
            firma.setDescripcion(cursor.getString(2));
            firma.setFirma(cursor.getBlob(1));
            lista.add(firma);
        }
        cursor.close();
        return lista;
    }
}