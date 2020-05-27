package com.example.homecaremobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class AccueilProrietaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_prorietaire);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                /* DO EDIT */
                return true;
            case R.id.action_add:
                /* DO ADD */
                return true;
            case R.id.action_delete:
                /* DO DELETE */
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
