package hva.studentportal.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hva.studentportal.R;
import hva.studentportal.adapters.PortalAdapter;
import hva.studentportal.models.Portal;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addPortal;
    private RecyclerView recyclerView;
    private PortalAdapter portalAdapter;
    private List<Portal> portalList;

    //Constants
    public final static String TAGTWO = "PORTALVIEW";
    public static final int REQUESTCODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init values
        addPortal = findViewById(R.id.btn_add_portal);
        recyclerView = findViewById(R.id.recyclerView);
        portalList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        updateUI();
        addPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPortalActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

    //Goes to the webview
    private void viewPortal(Context context, Portal portal) {
        Intent intent = new Intent(context, ViewPortalActivity.class);
        intent.putExtra(TAGTWO, portal);
        startActivity(intent);
    }

    private void updateUI() {
        if (portalAdapter == null) {
            portalAdapter = new PortalAdapter(portalList, new PortalAdapter.onItemClickListener() {
                @Override
                public void onItemClick(Portal portal) {
                    viewPortal(MainActivity.this, portal);
                }
            });
            recyclerView.setAdapter(portalAdapter);
        } else {
            portalAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE) {
            if (resultCode == RESULT_OK) {
                Portal newPortal = data.getParcelableExtra(AddPortalActivity.TAG);
                portalList.add(newPortal);
                updateUI();
            }
        }
    }
}
