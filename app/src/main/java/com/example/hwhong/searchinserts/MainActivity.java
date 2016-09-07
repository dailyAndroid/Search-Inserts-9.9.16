package com.example.hwhong.searchinserts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mauker.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String CONTENT_AUTHORITY = "br.com.mauker.materialsearchview.searchhistorydatabase";

    private MaterialSearchView materialSearchView;
    private Button add, finish, open;
    private EditText editText;

    private String[] strings;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strings = new String[10];

        add = (Button) findViewById(R.id.add);
        finish = (Button) findViewById(R.id.finish);
        open = (Button) findViewById(R.id.open);
        editText = (EditText) findViewById(R.id.editText);

        add.setOnClickListener(this);
        finish.setOnClickListener(this);
        open.setOnClickListener(this);

        materialSearchView = (MaterialSearchView) findViewById(R.id.msv);
        materialSearchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You clicked on item " + i, Toast.LENGTH_SHORT).show();
            }
        });


        counter = 0;
    }

    @Override
    public void onBackPressed() {

        if(materialSearchView.isOpen()) {
            materialSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add:
                strings[counter] = editText.getText().toString();
                counter++;
                break;
            case R.id.finish:
                materialSearchView.addSuggestions(new String[]{"spotify", "new York", "Beme",
                        "knicks", "sports", "intern", "beans"});
                break;
            case R.id.open:
                materialSearchView.openSearch();
                break;
        }
    }
}
