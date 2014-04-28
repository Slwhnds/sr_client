package petrsu.smartroom.android.cameraclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	
	private SimpleAdapter adapter;
	
	private List<Camera> cameras;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setUpList()
    {        
        List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
        ListIterator i = cameras.listIterator();
        
        while (i.hasNext())
        {
            Map<String, Camera> map = new HashMap<String, Camera>();
            //map.put("title", i.next().getIP());
            list.add(map);
        }
    }

}
