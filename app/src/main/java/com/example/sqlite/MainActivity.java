package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView=findViewById(R.id.list_student);

        DBManager dbManager=new DBManager(this);



//        listStudent.add(new Student("Nguyễn Văn A","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn B","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn C","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn D","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn E","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn F","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn G","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn H","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn L","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//        listStudent.add(new Student("Nguyễn Văn M","20/10/1999","a.nt@sis.hust.edu.vn","Hà Nội"));
//
//        for(Student student: listStudent){
//            dbManager.addStudent(student);
//        }

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

        }
        return true;
    }
}
