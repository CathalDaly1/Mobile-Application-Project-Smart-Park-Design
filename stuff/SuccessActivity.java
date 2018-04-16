package net.simplifiedlearning.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class SuccessActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, MainActivity.class));

                return true;

            case R.id.menuEditProfile:
                startActivity(new Intent(this, ProfileActivity.class));

                return true;

            case R.id.menuLogin:
                startActivity(new Intent(this, MainActivity.class));
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //super.onPrepareOptionsMenu(menu);
        boolean loggedIn;
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null)
        {
            loggedIn = false;
        }
        else
        {
            loggedIn = true;
        }
        if(loggedIn == false)
        {
            invalidateOptionsMenu();
            menu.findItem(R.id.menuLogout).setVisible(false);
            menu.findItem(R.id.menuEditProfile).setVisible(false);

        }
        else {
            invalidateOptionsMenu();
            menu.findItem(R.id.menuLogin).setVisible(false);

        }

        return super.onPrepareOptionsMenu(menu);
    }
}