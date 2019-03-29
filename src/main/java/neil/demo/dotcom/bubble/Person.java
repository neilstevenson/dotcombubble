package neil.demo.dotcom.bubble;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

	private String firstName;
	private String lastName;
	
}
