package com.example.pavanpucha.quizapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.checked;
import static android.R.attr.duration;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    String ques1Answer = "Brian De Palma";

   // boolean ques2Answer = true;
 //   boolean finalQ2Answer, finalQues4answer, finalQ1answer, finalQ3Answer;
    String ques3Answer = "9";
    String ques4Answer = "Donald Trump";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickedSubmit(View v) {


        CharSequence text;
        if (verifyQ1() && verifyQ2() && verifyQ3() && verifyQ4()) {
            text = "everything are correct";

        } else
            text = "Recheck your answers";
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private boolean verifyQ4() {
        EditText question4ans = (EditText) (findViewById(R.id.ques4Input));
        String que4Ans = question4ans.getText().toString();
      //  Log.v("this activity", "has " + que4Ans);
        if (que4Ans.equals(ques4Answer))
            return true;
        return false;
    }

    public boolean verifyQ3() {
        EditText question3ans = (EditText) (findViewById(R.id.ques3Input));
        String que3Ans = question3ans.getText().toString();
        if (que3Ans.equals(ques3Answer))
            return true;
        return false;
    }

    public boolean verifyQ2() {
        CheckBox qa1 = (CheckBox) (findViewById(R.id.cb1Input));
        boolean q1a = qa1.isChecked();
        CheckBox qa2 = (CheckBox) (findViewById(R.id.cb2Input));
        boolean q2a = qa2.isChecked();
        CheckBox qa3 = (CheckBox) (findViewById(R.id.cb3Input));
        boolean q3a = qa3.isChecked();
        CheckBox qa4 = (CheckBox) (findViewById(R.id.cb4Input));
        boolean q4a = qa4.isChecked();

        if (q1a && q2a && q3a && !q4a)
            return true;
        return false;
    }

    public boolean verifyQ1() {

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);

        if (rg.getCheckedRadioButtonId() == R.id.radioButton2)
            return true;
        return false;
    }
}
