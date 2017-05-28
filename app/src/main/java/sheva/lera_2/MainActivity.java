package sheva.lera_2;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgGroup = (RadioGroup) findViewById(R.id.rgGroup);

        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rbButton1:
                        Toast.makeText(MainActivity.this, "Hello from button 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbButton2:
                        Toast.makeText(MainActivity.this, "Hello from button 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbButton3:
                        Toast.makeText(MainActivity.this, "Hello from button 3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
