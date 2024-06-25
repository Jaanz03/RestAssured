package resources;

public enum AddPlaceResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	AddPlaceResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
		

}
