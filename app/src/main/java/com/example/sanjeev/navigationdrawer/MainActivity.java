package com.example.sanjeev.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_id);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.inbox_id:
                Toast.makeText(getApplicationContext(),"Indox",Toast.LENGTH_SHORT).show();
                break;
            case R.id.starred_id:
                Toast.makeText(getApplicationContext(),"Starred",Toast.LENGTH_SHORT).show();
            break;
            case R.id.sent_id:
                Toast.makeText(getApplicationContext(),"Sent Mail",Toast.LENGTH_SHORT).show();
            break;
            case R.id.draft_id:
                Toast.makeText(getApplicationContext(),"Draft",Toast.LENGTH_SHORT).show();
            break;
            case R.id.all_mail:
                Toast.makeText(getApplicationContext(),"ALl Mail",Toast.LENGTH_SHORT).show();
            break;
            case R.id.trash_id:
                Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
                break;
            case R.id.spam:
                Toast.makeText(getApplicationContext(),"Spam",Toast.LENGTH_SHORT).show();
            break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
