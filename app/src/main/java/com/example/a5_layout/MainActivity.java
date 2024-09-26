package com.example.a5_layout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tugas2.R;

public class MainActivity extends AppCompatActivity {
    private TextView hasilnya;
    private EditText txtinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Pastikan layout ini sesuai dengan activity_main.xml

        // Set padding for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan TextView dan Button ke layout
        hasilnya = findViewById(R.id.result);
        Button btn = findViewById(R.id.button);

        // Menentukan aksi pada tombol
        btn.setOnClickListener(v -> tampil_input());
    }

    private void tampil_input() {
        // Inflate layout input_dialog.xml
        LayoutInflater li = LayoutInflater.from(this);
        View inputnya = li.inflate(R.layout.input_dialog, null);

        // Membuat dialog
        AlertDialog.Builder dialognya = new AlertDialog.Builder(this);
        dialognya.setView(inputnya);

        // Menghubungkan EditText dari input_dialog.xml
        txtinput = inputnya.findViewById(R.id.edittext);

        // Menambahkan aksi pada tombol dialog
        dialognya
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Ketika tombol Ok ditekan, tampilkan hasil di TextView
                        hasilnya.setText(txtinput.getText().toString());
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Tutup dialog saat Batal ditekan
                        dialog.cancel();
                    }
                });

        // Menampilkan dialog
        dialognya.show();
    }
}
