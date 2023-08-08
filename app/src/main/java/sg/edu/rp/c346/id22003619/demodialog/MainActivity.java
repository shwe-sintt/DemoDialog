package sg.edu.rp.c346.id22003619.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Button btnDemo1;
Button btnDemo2;
TextView tvDemo2;
Button btnDemo3;
TextView tvDemo3;
Button btnEx3;
TextView tvEx3;
Button btnDemo4;
TextView tvDemo4;
Button btnDemo5;
TextView tvDemo5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo2=findViewById(R.id.buttonDemo2);
        tvDemo2=findViewById(R.id.textViewDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        tvDemo3=findViewById(R.id.textViewDemo3);
        btnEx3=findViewById(R.id.buttonExercise3);
        tvEx3=findViewById(R.id.textViewExercise3);
        btnDemo4=findViewById(R.id.buttonDemo4);
        tvDemo4=findViewById(R.id.textViewDemo4);
        btnDemo5=findViewById(R.id.buttonDemo5);
        tvDemo5=findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mybuilder=new AlertDialog.Builder(MainActivity.this);
//                mybuilder.setTitle("Demo 1 - Simple Dialog");
//                mybuilder.setMessage("I can develop Android app");
//                mybuilder.setCancelable(false);
//                mybuilder.setPositiveButton("Close", null);

                mybuilder.setTitle("Congradulations");
                mybuilder.setMessage("You have completed a simple Dialog box.");
                mybuilder.setCancelable(true);
                mybuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = mybuilder.create();
                myDialog.show();
            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mybuilder=new AlertDialog.Builder(MainActivity.this);
                mybuilder.setTitle("Demo 2 - Buttons Dialog");
                mybuilder.setMessage("Select one of the Buttons below");
                mybuilder.setCancelable(false);
                mybuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });
                mybuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });
                mybuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog= mybuilder.create();
                myDialog.show();
            }
        });
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.ex3, null);
                final EditText etInput1 = viewDialog.findViewById(R.id.editText1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editText2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        Double num1=Double.parseDouble(etInput1.getText().toString());
                        Double num2=Double.parseDouble(etInput2.getText().toString());
                        Double sum=num1+num2;
                        String message = "The sum is "+ sum;
                        // Set the text to the TextView
                        tvEx3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                };
                DatePickerDialog myDateDialog=new DatePickerDialog(MainActivity.this, myDateListener, year,month,day);
                myDateDialog.show();
            }
        });
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int hour=calendar.get(Calendar.HOUR);
                int minute=calendar.get(Calendar.MINUTE);
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String time;
                        if(hourOfDay<12){
                            time="am";
                        }else{
                            time="pm";
                        }
                        tvDemo5.setText("Time: "+ hourOfDay+":"+minute+time);

                    }
                };
                TimePickerDialog myTimeDialog=new TimePickerDialog(MainActivity.this, myTimeListener,hour,minute,false);
                myTimeDialog.show();
            }
        });

    }
}