package kesari.login_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

      private EditText Name;
      private EditText Psw;
      private Button  Btn;
      private TextView  disp;
      private int counter=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          Name=(EditText) findViewById(R.id.etusnm);
          Psw=(EditText) findViewById(R.id.etpsw);
           Btn=(Button) findViewById(R.id.btn);
          disp=(TextView) findViewById(R.id.dsp);

            disp.setText("No of attempts : 0 ");
            disp.setTextSize(32);
           Btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   check(Name.getText().toString(),Psw.getText().toString());
               }
           });

    }

    private void check(String Usnme,String Psw)
    {
        if(Usnme.equals("deepak")  && Psw.equals("1234"))
        {
            Intent intent = new Intent(MainActivity.this,otherActivity.class) ;
              startActivity(intent);
        }
        else
        {   counter++;
             disp.setText("No of attempts remaining: " + String.valueOf(4-counter));

                if(counter==4)
                {
                    Btn.setEnabled(false);
                }
        }

    }

    private class Start {
    }
}
