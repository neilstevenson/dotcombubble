package neil.demo.dotcom.bubble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ApplicationRunner implements CommandLineRunner {
	
	@Autowired
	private HazelcastInstance hazelcastInstance;
	
	@Override
	public void run(String... args) throws Exception {
		
		IMap<Integer, Person> personMap = this.hazelcastInstance.getMap("stooges");
		
		Person person1 = new Person("Curly", "Howard");
		Person person2 = new Person("Larry", "Howard");
		Person person3 = new Person("Moe", "Howard");
		
		personMap.put(1, person1);
		personMap.put(2, person2);
		personMap.put(3, person3);
		
		log.info("Map '{}' size=={}", personMap.getName(), personMap.size());
	}

}
