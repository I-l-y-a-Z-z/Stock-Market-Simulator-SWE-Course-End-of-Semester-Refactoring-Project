import com.google.gson.Gson;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/** Checks that the course libraries are discovered and work together under Java 17. */
@ExtendWith(MockitoExtension.class)
class CourseDependenciesTest {
    @Mock
    private Consumer<String> receiver;

    // A record also checks that tests compile against the upgraded Java baseline.
    private record Platform(String name) {}

    @ParameterizedTest
    @ValueSource(strings = {"Ubuntu", "Windows"})
    void jsonRoundTripWorksWithTheMockitoExtension(String name) {
        Gson gson = new Gson();
        Platform original = new Platform(name);

        Platform restored = gson.fromJson(gson.toJson(original), Platform.class);

        assertEquals(original, restored);
        receiver.accept(restored.name());
        verify(receiver).accept(name);
    }
}
