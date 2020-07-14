import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<Todo> todos = new ArrayList();
        try {
            String todoJson =
                    FileUtils.
                            readFileToString(new File("E:\\Estudos\\avançado\\bootcampigtiJAVA\\src\\main\\java\\data\\todo.js"), "UTF-8");
            Type todoListType = new TypeToken<ArrayList<Todo>>() {}.getType();
            Gson gson = new GsonBuilder().create();
            todos = gson.fromJson(todoJson, todoListType);
            todos = (ArrayList) todos.stream()
                    .filter(item -> item.getCompleted().equals(true))
                    .collect(Collectors.toList());

            System.out.println(todos.size());
            for (Todo todo: todos) {
                System.out.println(todo.getTitle());
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
