package com.koscom.enkore.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Parser {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Optional<String> parseId(String sid) {
        String id = null;
        try {
            id = sid;
        } catch (Exception e) {
            logger.debug("An error occured: {}", e.getMessage());
        }

        return Optional.ofNullable(id);
    }
}
