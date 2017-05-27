package sheva.lerafirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button btnSubmit;
    TextView tvShowText;
    EditText etEnterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvShowText = (TextView) findViewById(R.id.tvShowText);
        etEnterText = (EditText) findViewById(R.id.etEnterText);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvShowText.setText(etEnterText.getText());
            }
        });


    }

}
