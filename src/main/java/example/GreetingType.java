package example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static java.util.Arrays.stream;

public enum GreetingType {

    GOOD_MORNING(1),
    GOOD_EVENING(2);

    private final Integer id;

    GreetingType(final Integer id) {
        this.id = id;
    }

    @JsonCreator
    public static GreetingType forValue(final Integer id) {
        return stream(values()).filter(type -> type.id.equals(id)).findFirst().orElse(null);
    }

    @JsonValue
    public Integer getValue() {
        return id;
    }
}
