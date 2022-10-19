package edu.hanoi.jazz.service;

import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

public class JazzConnectionSignUp implements ConnectionSignUp {
    private static Logger logger = Logger.getLogger(JazzConnectionSignUp.class);

    @Autowired
    private static UserDAO userDAO;

    @Override
    public String execute(final Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        logger.info("-=----------> id " + userProfile.getId() + " name: " + userProfile.getName());
        User user = userDAO.get(userProfile.getUsername());
        if (user != null) return user.getUsername();
        user = new User();
        user.setUsername(userProfile.getUsername());
        user.setPassword("123");
        user.setGroupId(1);
        user.setEmail(userProfile.getEmail());
        userDAO.insert(user);
        return user.getUsername();
    }
}
