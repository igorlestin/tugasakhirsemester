package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    public static final String EXTRA_UID = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_UID";
    public static final String EXTRA_NAME = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_NAME";
    public static final String EXTRA_AGE = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_AGE";
    public static final String EXTRA_WEIGHT = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_WEIGHT";
    public static final String EXTRA_HEIGHT = "id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.EXTRA_HEIGHT";

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextWeight;
    private EditText editTextHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile);
        editTextName = findViewById(R.id.name);
        editTextAge = findViewById(R.id.age);
        editTextWeight = findViewById(R.id.weight);
        editTextHeight = findViewById(R.id.height);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_UID)) {
            setTitle(R.string.edit_profile_title);
            editTextName.setText(intent.getStringExtra(EXTRA_NAME));
            editTextAge.setText(intent.getStringExtra(EXTRA_AGE));
            editTextWeight.setText(String.valueOf(intent.getIntExtra(EXTRA_WEIGHT, 55)));
            editTextHeight.setText(String.valueOf(intent.getIntExtra(EXTRA_HEIGHT, 160)));

        } else {
            setTitle("Add Profile");
        }
    }

    private void saveProfile() {

        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();
        int weight = Integer.parseInt(editTextWeight.getText().toString());
        int height = Integer.parseInt(editTextHeight.getText().toString());
        if ( name.trim().isEmpty() ) {
            Toast.makeText(this, R.string.toast_enter_name, Toast.LENGTH_SHORT).show();
            return;
        } else if (age.trim().isEmpty()) {
            Toast.makeText(this, R.string.toast_enter_age, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent(ProfileActivity.this, MainActivity.class);
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_AGE, age);
        data.putExtra(EXTRA_HEIGHT, height);
        data.putExtra(EXTRA_WEIGHT, weight);

        long id = getIntent().getLongExtra(EXTRA_UID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_UID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_save_profile, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_profile:
                saveProfile();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
