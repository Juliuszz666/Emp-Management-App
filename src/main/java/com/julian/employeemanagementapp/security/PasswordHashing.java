package com.julian.employeemanagementapp.security;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;


public class PasswordHashing {

        private static final int SALT_LENGTH = 16;
        private static final int ITERATIONS = 16;
        private static final int MEMORY = 65536;
        private static final int PARALLELISM = 1;
        private static final int HASH_LENGTH = 48;
        private static final Argon2PasswordEncoder ARGON2 = new Argon2PasswordEncoder
                (SALT_LENGTH,
                HASH_LENGTH,
                PARALLELISM,
                MEMORY,
                ITERATIONS);

        public static String hashPassword(String password) {
            return ARGON2.encode(password);
        }

        public static boolean verifyPassword(String password, String hashedPassword) {
            return ARGON2.matches(password, hashedPassword);
        }
}
