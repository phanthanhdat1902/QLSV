package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqlite.adapter.StudentAdapter;
import com.example.sqlite.data.DBManager;
import com.example.sqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> listStudent=new ArrayList<>();
    List<Student> listStudentSQLite=new ArrayList<>();
    StudentAdapter studentAdapter;
    ListView listView;
    String name, address,email,date;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView=findViewById(R.id.list_student);

       dbManager=new DBManager(this);


        listStudentSQLite=dbManager.getListStudent();
        studentAdapter=new StudentAdapter(this,R.layout.item,listStudentSQLite);
        listView.setAdapter(studentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.add){
            dialogAdd();
        }
        return true;
    }
    private void dialogAdd(){
        final Dialog dialogAdd=new Dialog(this);
        dialogAdd.setContentView(R.layout.dialog_add);
        final EditText editName=dialogAdd.findViewById(R.id.edit_name);
        final EditText editDate=dialogAdd.findViewById(R.id.edit_date);

        final EditText editAddress=dialogAdd.findViewById(R.id.edit_address);

        final EditText editEmail=dialogAdd.findViewById(R.id.edit_mail);
        Button buttonSave=dialogAdd.findViewById(R.id.button_save);

        dialogAdd.show();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=editName.getText().toString();
                address=editAddress.getText().toString();
                date=editDate.getText().toString();
                email=editEmail.getText().toString();
                Student student=new Student(name, date,email,address);
                dbManager.addStudent(student);
                studentAdapter.add(student);
                dialogAdd.dismiss();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentAdapter.notifyDataSetChanged();
    }
}
