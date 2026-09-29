package co.commet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommetTest {

    @Test
    void validKeyBuilds() {
        for (String prefix : new String[]{"ck_", "ck_live_", "ck_sandbox_", "rk_", "rk_live_", "rk_sandbox_"}) {
            Commet commet = Commet.builder().apiKey(prefix + "test_123456").build();
            assertNotNull(commet);
            commet.close();
        }
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
