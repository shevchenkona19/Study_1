package sheva.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    Button btnForward;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btnForward = (Button) findViewById(R.id.btnForward);
        etInput = (EditText) findViewById(R.id.etTextInput);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("TEXT", etInput.getText().toString());
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("BUNDLE", bundle);
                startActivity(intent);
                finish();
                Log.d("MY", "Button click");
            }
        });

        Log.d("MY", "onCreate FirstActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MY", "onStart FirstActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MY", "onResume FirstActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MY", "onPause FirstActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MY", "onStop FirstActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MY", "onDestroy FirstActivity");
    }
}
