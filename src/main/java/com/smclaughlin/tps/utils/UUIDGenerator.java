package com.smclaughlin.tps.utils;

import java.util.UUID;

/**
 * Created by sineadmclaughlin on 11/12/2016.
 */
@FunctionalInterface
public interface UUIDGenerator {

    static UUID randomUUID() { return UUID.randomUUID(); }
    UUID customRandomUUID();
}
