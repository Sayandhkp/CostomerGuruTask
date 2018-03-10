package saykp.dev.testsignupandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText inputName;
    protected EditText editNumber;
    protected EditText editEmail;
    protected Spinner spinner;
    protected Button buttonValidate;
    String spinnerData=null;
    String [] spinnerItem={"Select one", "Delhi","Mumbai","Kolkata","Chennai","banglore"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();


        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,spinnerItem);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position!=0){
                    spinnerData=spinnerItem[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonValidate) {
            if (validate()){
                Toast.makeText(MainActivity.this, "Validation success", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Validation failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initView() {
        inputName = (EditText) findViewById(R.id.input_name);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editEmail = (EditText) findViewById(R.id.editEmail);
        spinner = (Spinner) findViewById(R.id.spinner);
        buttonValidate = (Button) findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(MainActivity.this);
    }

    public boolean validate() {
        boolean valid = true;


        String name = inputName.getText().toString();
        String mobile=editNumber.getText().toString();
        String email= editEmail.getText().toString();

        if (spinnerData==null){
            Toast.makeText(MainActivity.this, "Please select city", Toast.LENGTH_SHORT).show();
            valid=false;
        }

        if (!name.isEmpty()) {
            Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
            Matcher ms = ps.matcher(name);
            boolean bs = ms.matches();

            if (!bs){
                inputName.setError("Only alphates allowed and its mandatory");
                valid = false;
            }

        } else {
            inputName.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Enter a valid email address");
            valid = false;
        } else {
            editEmail.setError(null);
        }

       if (mobile.length()!=10){
            editNumber.setError("Invalid number");
       }else {
           editEmail.setError(null);
       }
        return valid;
    }


}
