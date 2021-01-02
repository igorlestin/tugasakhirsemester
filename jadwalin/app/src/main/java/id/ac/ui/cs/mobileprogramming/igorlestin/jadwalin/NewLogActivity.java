package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewLogActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_ID";
    public static final String EXTRA_AMOUNT = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_AMOUNT";
    public static final String EXTRA_DATE = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_DATE";
    public static final String EXTRA_TIME = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_TIME";

    private EditText mEditLogView;
    private EditText editTextAmount;
    private EditText editTextDate;
    private EditText editTextTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_log);

        editTextAmount = findViewById(R.id.amount);
        editTextDate = findViewById(R.id.date_picker);
        editTextTime = findViewById(R.id.weight);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle(R.string.edit_activity_title);
            editTextAmount.setText(String.valueOf(intent.getIntExtra(EXTRA_AMOUNT, 000)));
            editTextDate.setText(intent.getStringExtra(EXTRA_DATE));
            editTextTime.setText(intent.getStringExtra(EXTRA_TIME));
        } else {
            setTitle(R.string.add_activity_title);
        }

    }

    private void saveLog() {

        String amount = String.valueOf(editTextAmount.getText());

        String date = editTextDate.getText().toString();
        String time = editTextTime.getText().toString();
        if ( date.trim().isEmpty() || time.trim().isEmpty() ) {
            Toast.makeText(this, "Insert amount", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_AMOUNT, amount);
        data.putExtra(EXTRA_DATE, date);
        data.putExtra(EXTRA_TIME, time);

        long id = getIntent().getLongExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add_log, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_log:
                saveLog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}