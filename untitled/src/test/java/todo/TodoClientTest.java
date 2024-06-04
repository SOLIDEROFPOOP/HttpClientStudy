package todo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoClientTest {

    TodoClient client = new TodoClient();

    @Test
    void findAll() throws IOException, InterruptedException {
        List<Todo> todos = client.getTodos();
        assertEquals(200,todos.size());
    }
    
}