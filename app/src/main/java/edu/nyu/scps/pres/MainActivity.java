package edu.nyu.scps.pres;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView)findViewById(R.id.listView);
        TextView textView = (TextView)findViewById(R.id.empty);
        listView.setEmptyView(textView);   //Display this TextView when table conta

        Helper helper = new Helper(this);
        Cursor cursor = helper.getCursor();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.pres_layout,
                cursor,
                new String[] {"_id",   "lastname",    "firstname",    "ss"},
                new int[]    {R.id.id, R.id.lastname, R.id.firstname, R.id.ss},
                0	//don't need any flags
        );
        listView.setAdapter(adapter);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
