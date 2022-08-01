package com.example.filewriteread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
    }
    public void onSave(View v)throws IOException {
        FileOutputStream fout;
        fout=openFileOutput(e1.getText().toString(),0);
        OutputStreamWriter osw=new OutputStreamWriter(fout);
        osw.write(e2.getText().toString());
        osw.flush();
        osw.close();
    }
    public void onRead(View v)throws IOException{
        FileInputStream fin;
        fin=openFileInput(e1.getText().toString());
        InputStreamReader isw=new InputStreamReader(fin);
        char []b=new char[100];
        int n=isw.read(b,0,100);
        String str=new String(b,0,n);
        e2.setText(str);
        isw.close();
    }


}