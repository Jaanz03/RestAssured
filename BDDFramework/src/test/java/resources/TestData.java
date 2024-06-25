package resources;

import java.util.ArrayList;
import java.util.List;

import pojoclasses.AddplaceAPI;
import pojoclasses.locationfieldsapi;

public class TestData {
	
	public  AddplaceAPI AddPlacePayload(String name, String phonenumber, String address) {
	
		AddplaceAPI p = new AddplaceAPI();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage("French-IN");
		p.setPhone_number(phonenumber);
		p.setWebsite("http://google.com");
		p.setName(name);
		List<String>	mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		locationfieldsapi	l=new locationfieldsapi();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
		}
}

