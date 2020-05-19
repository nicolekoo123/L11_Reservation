package sg.edu.rp.c346.id19047433.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etNumber;
    EditText etSize;
    CheckBox CBSmoking;
    DatePicker Dp;
    TimePicker Tp;
    Button btnSubmit;
    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etNumber = findViewById(R.id.etNumber);
        etSize = findViewById(R.id.etSize);
        CBSmoking = findViewById(R.id.CheckboxSmoking);
        Dp = findViewById(R.id.datePicker);
        Tp = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.ButtonSubmit);
        btnReset = findViewById(R.id.ButtonReset);
        Dp.updateDate(2020,6,1);
        Tp.setHour(19);
        Tp.setMinute(30);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String size = etSize.getText().toString();
                String number = etNumber.getText().toString();
                if(name.isEmpty() || size.isEmpty() || number.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all the required information", Toast.LENGTH_SHORT).show();
                    return;
                }
                Calendar now = Calendar.getInstance();
                Calendar res = Calendar.getInstance();
                res.set(Dp.getYear(), Dp.getMonth(), Dp.getDayOfMonth(), Tp.getCurrentHour(), Tp.getCurrentMinute());
                if(now.after(res)){
                    Toast.makeText(MainActivity.this, "PLease Select a date and time after today", Toast.LENGTH_SHORT).show();
                    return;
                }
                String smoking = "";
                if(CBSmoking.isChecked()){
                    smoking = "Smoking";
                }
                else{
                    smoking = "Non-Smoking";
                }
                Toast.makeText(MainActivity.this, "HI, " + etName.getText().toString() + "You have booked a " + etSize.getText().toString() + " Person" + smoking + "table on " + Dp.getYear() + "/ " + (Dp.getMonth() +1) + "/" + Dp.getDayOfMonth() + Tp.getCurrentHour() + ":" + Tp.getCurrentMinute() + " Your phone number " + etNumber.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etNumber.setText("");
                etSize.setText("");
                Tp.setCurrentHour(0);
                Tp.setCurrentMinute(0);
                Dp.updateDate(2020, 0, 1);
                CBSmoking.setChecked(false);
            }
        });
        
    }
}
