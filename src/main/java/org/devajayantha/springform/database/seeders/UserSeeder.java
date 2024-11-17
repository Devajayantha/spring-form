package org.devajayantha.springform.database.seeders;

import org.devajayantha.springform.models.entities.User;
import org.devajayantha.springform.repositories.UserRepository;
import org.devajayantha.springform.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import java.util.ArrayList;

@Component
public class UserSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerUtil.getLogger(UserSeeder.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("User 1", "user1@webtech.id", passwordEncoder.encode("password1")));
        users.add(new User("User 2", "user2@webtech.id", passwordEncoder.encode("password2")));
        users.add(new User("User 3", "user3@worldskills.org", passwordEncoder.encode("password3")));

        logger.info("Starting UserSeeder...");

        for (User user : users) {
            if (!userRepository.existsByEmail(user.getEmail())) {
                userRepository.saveAndFlush(user);

                logger.info("Saved user: " + user.getEmail());
            }
        }

        logger.info("Finished UserSeeder.");
    }
}
