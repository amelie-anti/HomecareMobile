package com.example.homecaremobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainProprietaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_proprietaire);


        List<Bien> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Bien bien = (Bien) o;
                Toast.makeText(MainProprietaireActivity.this, "Selected : " + " " + bien, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<Bien> getListData() {
        List<Bien> list = new ArrayList<Bien>();
        Bien etude = new Bien("55rue de Mirambeau", "Anglet","31470","2011",11);
        Bien maison = new Bien("1rue des begonias", "Fonsorbes","64600","2005",200);

        list.add(etude);
        list.add(maison);

        return list;
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
