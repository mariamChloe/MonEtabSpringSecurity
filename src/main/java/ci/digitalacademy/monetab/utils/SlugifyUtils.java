package ci.digitalacademy.monetab.utils;

import com.github.slugify.Slugify;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
@Slf4j
public final class SlugifyUtils  {

    // Private constructor to prevent instantiation
    private SlugifyUtils() {
    }

    // Method to slugify the input string
    public static String genereted(String input) {
        String value = String.format("%s, %s", input, UUID.randomUUID());

        final Slugify slg = Slugify.builder().underscoreSeparator(true).build();
        final String result = slg.slugify(value);
 //result: hello_world;
        return slg.slugify(value);
    }

}
