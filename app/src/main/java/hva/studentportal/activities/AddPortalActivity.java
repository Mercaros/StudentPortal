package hva.studentportal.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hva.studentportal.R;
import hva.studentportal.models.Portal;

/**
 * Created by khaled on 06-10-18.
 */

public class AddPortalActivity extends AppCompatActivity {
    private EditText urlLink;
    private EditText titleName;
    private Button confirmPortal;
    public final static String TAG = "PORTAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        setTitle(getString(R.string.addportal_title));
        urlLink = findViewById(R.id.urlLink);
        titleName = findViewById(R.id.titleName);
        //Cursor starts at the end of the text
        urlLink.setSelection(urlLink.getText().length());
        confirmPortal = findViewById(R.id.btn_confirm_portal);
        confirmPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(urlLink.getText().toString()) && !TextUtils.isEmpty(titleName.getText().toString())) {
                    Portal portal = new Portal(urlLink.getText().toString(), titleName.getText().toString());
                    Intent intent = new Intent(AddPortalActivity.this, MainActivity.class);
                    intent.putExtra(TAG, portal);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    Toast.makeText(AddPortalActivity.this, R.string.portal_added, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddPortalActivity.this, R.string.fill_something, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
