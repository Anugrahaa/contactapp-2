package anugrahaa.contactsapp_androidapp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
//Array of strings storing contact names
	String[] contactname = new String[] {
		"Abix",
		"Bulbul",
		"Cayom",
		"Dolly",
		"Eula",
		"Freida",
		"Guyguy",
		"homi",
		"Igneous",
		"Jasmine",
		"Karla",
		"Lily",
		"Mann",
		"Nayom",
		"Oesterd",
		"Putty",
		"Queen",
		"Reeda",
		"Sam",
		"Triana"
	};
	
	//Array of integers points to images stored in /res/drawable-ld
	int[] icon = new int[]{
		R.drawable.img1,
		R.drawable.img2,
		R.drawable.img3,
		R.drawable.img4,
		R.drawable.img5,
		R.drawable.img6,
		R.drawable.img7,
		R.drawable.img8,
		R.drawable.img9,
		R.drawable.img10,
		R.drawable.img11,
		R.drawable.img12,
		R.drawable.img13,
		R.drawable.img14,
		R.drawable.img15,
		R.drawable.img16,
		R.drawable.img17,
		R.drawable.img18,
		R.drawable.img19,
		R.drawable.img20
	};
	//Array of Strings to store Contact nos.
	String[] phno = new String[]{
		"987654",
		"654321",
		"321654",
		"564789",
		"654123",
		"321569",
		"147852",
		"123965",
		"159357",
		"987789",
		"654456",
		"123321",
		"321123",
		"456654",
		"789987",
		"852258",
		"102541",
		"302657",
		"321002",
		"700896"
	};

	//Button to sort otherwise
	Button b1;

	int counter=0;

	//EditText for sorting
	EditText et;
	Button b2; //Go button for searching
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		//Each row in list stores name and phno and icons
		List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
		
		for(int i=0; i<20; i++){
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("txt","Name: "+ contactname[i]);
			hm.put("phno","Phone no.: "+ phno[i]);
			hm.put("icon", Integer.toString(icon[i]) );
			aList.add(hm);
		}
			
		//Keys used in HashMap
		String[] from = {"icon","txt","phno" };
		
		//ids of views in contact_row
		int[] to = { R.id.icon, R.id.txt, R.id.phno };
		
		//contact_row defines the layout of each row, so we use an Adapter here
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.contact_row, from, to);
		
		//Getting a reference to listview of main.xml layout file
		ListView listview = (ListView) findViewById(R.id.listview);
		
		//Setting the adapter to the listview
		listview.setAdapter(adapter);

		//Button
		b1=(Button) findViewById(R.id.button);

		b1.setOnClickListener(this);

		//EditText functionality
		et=(EditText) findViewById(R.id.search);
		b2=(Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);


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

	public void onClick(View v)
	{ if(v==b1)
	{
		counter++;
		if(counter%2==0)
		{
			List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

			for(int i=0; i<20; i++){
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("txt","Name: "+ contactname[i]);
				hm.put("phno","Phone no.: "+ phno[i]);
				hm.put("icon", Integer.toString(icon[i]) );
				aList.add(hm);
			}

			//Keys used in HashMap
			String[] from = {"icon","txt","phno" };

			//ids of views in contact_row
			int[] to = { R.id.icon, R.id.txt, R.id.phno };

			//contact_row defines the layout of each row, so we use an Adapter here
			SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.contact_row, from, to);

			//Getting a reference to listview of main.xml layout file
			ListView listview = (ListView) findViewById(R.id.listview);

			//Setting the adapter to the listview
			listview.setAdapter(adapter);

		}
		else
		{
			List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

			for(int i=19; i>=0; i--){
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("txt","Name: "+ contactname[i]);
				hm.put("phno","Phone no.: "+ phno[i]);
				hm.put("icon", Integer.toString(icon[i]) );
				aList.add(hm);
			}

			//Keys used in HashMap
			String[] from = {"icon","txt","phno" };

			//ids of views in contact_row
			int[] to = { R.id.icon, R.id.txt, R.id.phno };

			//contact_row defines the layout of each row, so we use an Adapter here
			SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.contact_row, from, to);

			//Getting a reference to listview of main.xml layout file
			ListView listview = (ListView) findViewById(R.id.listview);

			//Setting the adapter to the listview
			listview.setAdapter(adapter);
		}
	}
if(v==b2)
{
	String searchString = et.getText().toString();
	int i=0;
	for(; i<20; i++)
	{
		if(searchString.equalsIgnoreCase(contactname[i])==true) {
			Toast.makeText(getApplicationContext(), "Contact Found: " + searchString, Toast.LENGTH_LONG).show();
			break;
		}
	}
	if(i==20)
	{
		Toast.makeText(getApplicationContext(), "Missing", Toast.LENGTH_LONG).show();
	}
}


	}


}
