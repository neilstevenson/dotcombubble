package neil.demo.dotcom.bubble;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyController {

	private IMap<Integer, Person> personMap ;
	
	public MyController(HazelcastInstance hazelcastInstance) {
		this.personMap = hazelcastInstance.getMap("stooges");
	}
	
	@GetMapping(path = "/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable Integer id) {
		log.info("START : findById({})", id);

		// java,io.Serializable
		Person person = this.personMap.get(id);
		
		log.info("END : findById({}) => {}", id, person);
		
		return person;
	}

}
