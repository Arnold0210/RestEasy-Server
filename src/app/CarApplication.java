package app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import service.CarServiceImpl;

public class CarApplication extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public CarApplication() {
		singletons.add(new CarServiceImpl());
	}
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}
}
