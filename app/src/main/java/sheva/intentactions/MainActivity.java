package sheva.intentactions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvTel;
    private TextView tvCity;
    private TextView tvCountry;

    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = (TextView) findViewById(R.id.tvName);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvCity = (TextView) findViewById(R.id.tvCity);
        tvCountry = (TextView) findViewById(R.id.tvCountry);
        btnCreate = (Button) findViewById(R.id.btnNew);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
                startActivityForResult(intent, IConstants.Keys.NEW_USER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IConstants.Keys.NEW_USER){
            if (resultCode == RESULT_OK) {
                UserEntity user = data.getParcelableExtra(IConstants.Keys.USER_INTENT);
                tvName.setText(user.getName());
                tvTel.setText(user.getTelephone());
                tvCity.setText(user.getCity());
                tvCountry.setText(user.getCountry());
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "YOU STUPED!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
