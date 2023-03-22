package alura.com.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.agenda.DAO.StudentDAO;
import alura.com.agenda.R;

public class StudentListActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Student List";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        setTitle(TITLE_APPBAR);

        configureNewStudentFAB();

    }

    //Here are the extracted stuff for onCreate
    private void configureNewStudentFAB() {
        FloatingActionButton buttonNewStudent = findViewById(R.id.activity_student_list_fab_new_student);
        buttonNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFormStudentActivity();
            }
        });
    }

    private void openFormStudentActivity() {
        startActivity(new Intent(this,
                StudentFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configureList();
    }

    //Here are the extracted stuff for onResume
    private void configureList() {
        ListView studentList = findViewById(R.id.activity_student_list_lview);
        studentList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}