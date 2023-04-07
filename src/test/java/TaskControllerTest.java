import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {
    //@Mock
    private TaskRepo taskRepo;

     //@InjectMocks
     TaskController controller = new TaskController();

//     @BeforeEach
//     public void setUp(){
//         MockitoAnnotations.initMocks(this);
//     }


    @Test
    public void naoDeveSalvarTarefaSemDescricao()  {
        Task todo = new Task();
        todo.setId((long) 1);
        todo.setDueDate(LocalDate.now());
        todo.setTask("");

        try{
            controller.save(todo);
        }catch (ValidationException e){
            Assertions.assertEquals("Fill the task description", e.getMessage());
        }

    }

    @Test
    public void naoDeveSalvarTarefaSemData(){
        Task todo = new Task();
        todo.setId((long) 1);
        todo.setTask("Descrição");

        try{
            controller.save(todo);
        }catch (ValidationException e){
            Assertions.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTarefaComDataNoPassado(){
        Task todo = new Task();
        todo.setId((long) 1);
        todo.setDueDate(LocalDate.of(2016,07,17));
        todo.setTask("Descrição");

        try{
            controller.save(todo);
        }catch (ValidationException e){
            Assertions.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

//   @Test
//    public void salvarComSucessoUmaTarefa() throws ValidationException {
//        Task todo = new Task();
//        todo.setId((long) 1);
//        todo.setTask("teste");
//        todo.setDueDate(LocalDate.now());
//        controller.save(todo);
//
//        Mockito.verify(taskRepo).save(todo);
//    }
}
