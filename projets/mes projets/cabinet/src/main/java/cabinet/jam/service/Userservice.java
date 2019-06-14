package cabinet.jam.service;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import cabinet.jam.domaine.entities.Role;
import cabinet.jam.domaine.entities.User;
import cabinet.jam.repository.*;

@Service("userService")
public class Userservice {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	


	public Userservice(UserRepository userRepository,
			RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User saveUser(User user) {
		user.setPassword(user.getPassword());
		user.setActive(1);
		final Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}

}
