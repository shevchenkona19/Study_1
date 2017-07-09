package sheva.asynclera;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    TextView tv;
    Button bt;
    MyTask myTask = new MyTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        tv = (TextView) findViewById(R.id.textView);
        bt = (Button) findViewById(R.id.button);

        myTask.execute("Hello");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    //
                }
            }
        });

    }

    private class MyTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //
            }
            myTask.execute("bang");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            char[] chars = strings[0].toCharArray();
            List<Character> list = new ArrayList<>();
            int a = 0;
            for (int i = 0; i < chars.length; i ++) {
                publishProgress(a);
                list.add(chars[i]);
                list.add(Integer.toString(i).toCharArray()[0]);
                a +=20;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }
            }
            return list.toString();
        }
    }
}
