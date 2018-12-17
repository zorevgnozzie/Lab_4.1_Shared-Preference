package my.edu.tarc.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView txtViewName, txtViewSalutation;
    private ImageView imgViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtViewName = findViewById(R.id.txtViewName);
        txtViewSalutation = findViewById(R.id.txtViewSalutation);
        imgViewProfile = findViewById(R.id.imgViewProfile);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = getSharedPreferences(getString(R.string.pref_file), MODE_PRIVATE);
        String name;
        int gender; // -1 = default, 1 = male, 0 = female
        name = sharedPreferences.getString("name", "");
        gender = sharedPreferences.getInt("gender", -1);
        txtViewName.setText(name);
        if (gender == 1) {
            txtViewSalutation.setText("Mr.");
            imgViewProfile.setImageResource(R.drawable.male);
        } else if (gender == 0) {
            txtViewSalutation.setText("Ms.");
            imgViewProfile.setImageResource(R.drawable.female);
        } else {
            txtViewSalutation.setText("");
            imgViewProfile.setImageResource(R.drawable.profile);
        }


    }
}
