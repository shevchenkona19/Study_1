package sheva.intentactions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etCity;
    private EditText etCountry;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etCity = (EditText) findViewById(R.id.etCity);
        etCountry = (EditText) findViewById(R.id.etCcountry);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().length() == 0 ||
                        etPhone.getText().length() == 0 ||
                        etCity.getText().length() == 0 ||
                        etCountry.getText().length() == 0) {
                    Intent intent = new Intent(NewUserActivity.this, MainActivity.class);
                    setResult(RESULT_CANCELED, intent);
                    finish();
                } else {
                    UserEntity user = new UserEntity(etName.getText().toString(),
                            etPhone.getText().toString(), etCity.getText().toString(),
                            etCountry.getText().toString());
                    Intent intent = new Intent(NewUserActivity.this, MainActivity.class);
                    intent.putExtra(IConstants.Keys.USER_INTENT, user);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
