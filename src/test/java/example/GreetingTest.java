package example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kjetland.jackson.jsonSchema.JsonSchemaGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingTest {

    @Test
    public void greetingTypeShouldBeMappedToIntegerPropertyInJsonSchema() {
        // Given
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(objectMapper);

        // When
        JsonNode jsonSchema = jsonSchemaGenerator.generateJsonSchema(Greeting.class);

        // Then
        assertThat(jsonSchema.get("properties").get("type").get("type").textValue()).isEqualTo("integer");
    }
}
