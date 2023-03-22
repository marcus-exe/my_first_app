package alura.com.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import alura.com.agenda.DAO.StudentDAO;
import alura.com.agenda.R;
import alura.com.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "New Student";
    private EditText inputName;
    private EditText inputPhone;
    private EditText inputEmail;
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle(TITLE_APPBAR);
        initializingVariables();
        View saveButton = findViewById(R.id.activity_student_form_button_save);
        configureSaveButton(saveButton);

    }

    // All the extracted Functions bellow
    private void configureSaveButton(View saveButton) {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = createStudent();
                save(student);
            }
        });
    }

    private void initializingVariables() {
        inputName = findViewById(R.id.activity_student_form_name);
        inputPhone = findViewById(R.id.activity_student_form_number);
        inputEmail = findViewById(R.id.activity_student_form_email);
    }

    private void save(Student student) {
        dao.save(student);
        finish();
    }

    @NonNull
    private Student createStudent() {
        String name = inputName.getText().toString();
        String phone = inputPhone.getText().toString();
        String email = inputEmail.getText().toString();
        Student student = new Student(name, phone, email);
        return student;
    }
}