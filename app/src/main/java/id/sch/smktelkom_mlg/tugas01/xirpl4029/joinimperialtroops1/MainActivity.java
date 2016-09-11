package id.sch.smktelkom_mlg.tugas01.xirpl4029.joinimperialtroops1;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etAge;
    RadioButton rbD,rbA;
    Button bSubmit,bSubmit2;
    TextView tvView,tvView2,tvView3,tvView4;
    Spinner sW;
    CheckBox cbLMG,cbLS,cbLM,cbLC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editTextName);
        etAge = (EditText) findViewById(R.id.editTextAge);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);
        rbA = (RadioButton) findViewById(R.id.radioButtonA);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        bSubmit2 = (Button) findViewById(R.id.buttonSubmit2);
        tvView = (TextView) findViewById(R.id.textViewView);
        tvView2 = (TextView) findViewById(R.id.textViewView2);
        tvView3 = (TextView) findViewById(R.id.textViewView3);
        tvView4 = (TextView) findViewById(R.id.textViewView4);
        sW = (Spinner) findViewById(R.id.spinnerWarplace);
        cbLMG = (CheckBox) findViewById(R.id.checkBoxLMG);
        cbLS = (CheckBox) findViewById(R.id.checkBoxLS);
        cbLM = (CheckBox) findViewById(R.id.checkBoxLM);
        cbLC = (CheckBox) findViewById(R.id.checkBoxLC);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();

            }
        });
        bSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick2();
                doClick3();
            }
        });

    }

    private void doClick3() {
        tvView4.setText("Your Warplace :"+sW.getSelectedItem().toString());
    }

    private void doClick2() {
        String view3="Your Weapon: \n";
        int startlen = view3.length();
        if(cbLMG.isChecked())view3+=cbLMG.getText()+"\n";
        if(cbLS.isChecked())view3+=cbLS.getText()+"\n";
        if(cbLM.isChecked())view3+=cbLM.getText()+"\n";
        if(cbLC.isChecked())view3+=cbLC.getText()+"\n";
        if (view3.length()==startlen)view3+="No Weapon Picked";
        tvView3.setText(view3);
    }

    private void doClick() {
        String view2 = null;
        if (rbD.isChecked())
        {
            view2 = rbD.getText().toString();
        }
        else if (rbA.isChecked()){
            view2 = rbA.getText().toString();
        }
        if(view2 == null){
            tvView2.setText("You must choose your troops");
        }
        else{
            tvView2.setText("Your Troops : "+view2);
        }
    }

    private void doProcess() {
        if(isValid())
        {
            String name = etName.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());
            tvView.setText(name+", "+age+" years old");

        }
    }

    private boolean isValid()
    {
        boolean valid = true;
        String name = etName.getText().toString();
        String age = etAge.getText().toString();

        if(name.isEmpty())
        {
            etName.setError("You Must Insert Your Name");
            valid = false;
        }
        else if (name.length()<5)
        {
            etName.setError("Your Name Must Be at Least 5 Characters");
            valid = false;
        }
        else
        {
            etName.setError(null);
        }
        if (age.isEmpty())
        {
            etAge.setError("You Must Insert Your Age");
            valid = false;
        }
        else if (age.length()!=2)
        {
            etAge.setError("Your Age Must be More Than 10 Years and Less Than 100 Years");
            valid = false;
        }
        else{
            etAge.setError(null);
        }
        return valid;
    }
}
