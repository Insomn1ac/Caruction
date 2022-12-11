package org.intensive.caruction.util;

import lombok.experimental.UtilityClass;
import org.intensive.caruction.exception.ElementNotFoundException;
import org.intensive.caruction.exception.IllegalRequestDataException;

@UtilityClass
public class ValidationUtil {

    public static void checkModification(int count, int id) {
        if (count == 0) {
            throw new IllegalRequestDataException("Entity with id=" + id + " not found");
        }
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new ElementNotFoundException("Not found entity with " + msg);
        }
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }
}
