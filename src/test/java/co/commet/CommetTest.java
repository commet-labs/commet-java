package co.commet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommetTest {

    @Test
    void validKeyBuilds() {
        Commet commet = Commet.builder()
                .apiKey("ck_test_123456")
                .build();

        assertNotNull(commet);
        commet.close();
    }

    @Test
    void rejectsInvalidApiKeys() {
        assertThrows(IllegalArgumentException.class,
                () -> Commet.builder().apiKey(null).build());
        assertThrows(IllegalArgumentException.class,
                () -> Commet.builder().apiKey("").build());
        assertThrows(IllegalArgumentException.class,
                () -> Commet.builder().apiKey("sk_invalid").build());
    }
}
