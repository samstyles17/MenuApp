package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Toast toast;
    Toolbar toolbar;
    ImageView imageView;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);

        // Long click listener to open the floating context menu
        imageView.setOnLongClickListener(v -> {
            openContextMenu(v);
            return true;
        });

        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, fab);
                popupMenu.inflate(R.menu.popup_menu);

                popupMenu.setOnMenuItemClickListener(item -> {
                    int id = item.getItemId();

                    if (id == R.id.action_popup1) {
                        // Handle Popup 1 click
                        return true;
                    } else if (id == R.id.action_popup2) {
                        // Handle Popup 2 click
                        return true;
                    }

                    return false;
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.options_menu,menu);
      return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_option1) {
            toast = Toast.makeText(this,"Infomration Updated",Toast.LENGTH_LONG);
            toast.show();
//            return true;
        } else if (id == R.id.action_option2) {
            toast = Toast.makeText(this,"Added to Cart",Toast.LENGTH_LONG);
            toast.show();
            // Handle Option 2 click
//            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_context1) {
            toast = Toast.makeText(this,"Photo added to favorites",Toast.LENGTH_LONG);
            toast.show();
            // Handle Context 1 click
//            return true;
        } else if (id == R.id.action_context2) {
            toast = Toast.makeText(this,"Photo deleted",Toast.LENGTH_LONG);
            toast.show();
            // Handle Context 2 click
//            return true;
        }

        return super.onContextItemSelected(item);
    }

    public void showPopupMenu(View view)
    {

    }

}