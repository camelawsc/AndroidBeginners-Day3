package camelawong.day3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text ;
    Button button;
   Spinner spinner;
    String[] fruits;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        fruits = getResources().getStringArray(R.array.fruits);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.spinner, fruits);
        arrayAdapter.setDropDownViewResource(R.layout.spinner);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected = fruits[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        text = (TextView) findViewById(R.id.text);
        text.setText(getString(R.string.default_text));
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("--Select--")){
                    Toast.makeText(MainActivity.this, "Please select your fruit!", Toast.LENGTH_LONG).show();
                } else {
                    text.setText(selected);
                }
            }
        });
    }
}
