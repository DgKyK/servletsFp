package ua.alex.project.model.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Class that is responsible for hashing passwords;
 */
public class PasswordEncoder {

    public static String encodePassword(String password) {
        return  DigestUtils.md5Hex(password);
    }
}
