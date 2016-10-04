package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Car{
	int id;
	public Car(int id){
		this.id = id;
	}
	
}

public class HashMapTest {
	static HashMap<String, ArrayList<Car>> cars = new HashMap<String, ArrayList<Car>>();
	
	public static void addToList(String mapKey, Car myCar) {
		ArrayList<Car> carsList = cars.get(mapKey);
	 
	    // if list does not exist create it
	    if(carsList == null) {
	         carsList = new ArrayList<Car>();
	         cars.put(mapKey, carsList);
	    }
        carsList.add(myCar);
	}
	
	public static void main(String[] args){
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		Map<String, Integer> map = new HashMap<String, Integer>();
		Integer ret = map.put("key", a);
		System.out.println("Value is ret : " + ret);
		
		Integer ret1 = map.put("key", b);
		System.out.println("Value is ret1 : " + ret1);
		System.out.println("Value of key : " + (map.get("key") == b));
		
		Integer ret2 = map.put("key", a);
		System.out.println("Value is ret2 : " + ret2);
		System.out.println("Value of key : " + (map.get("key") == b));
		
		System.out.println("Value is b : " + (map.get("key") == b));
		
		Car car1 = new Car(10);
		Car car2 = new Car(20);
		Car car3 = new Car(30);
		
		addToList("mercedes", car1);
		addToList("benz", car2);
		addToList("mercedes", car3);
		addToList("fiat", car3);
		
		for(Entry<String, ArrayList<Car>> cars : cars.entrySet()){
			for(Car car : cars.getValue()){
				System.out.println(cars.getKey() + ":" + car.id);
			}
		}
	}	
}
