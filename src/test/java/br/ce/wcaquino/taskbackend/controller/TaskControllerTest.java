package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {
	
	@Mock
	private TaskRepo taskRepo;
	//declaracao do Mockito (qual atributo da classe principal será mockado)
	
	@InjectMocks
	private TaskController controller;
	//declaracao de ijeção do Mockito (classe principal em que o mockito fará a injeção dos mocks)
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	} // Inicializa o mockito
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		 Task todo = new Task();
	//	 todo.setTask("Descricao");
		 todo.setDueDate(LocalDate.now());
		// TaskController controller = new TaskController();     declarado como global, por isso comentado
		 try {
			controller.save(todo);
			Assert.fail("Não deveria ter chegado nesse ponto!"); //garante que o mock não esta afetando na validação do teste unitario
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the task description", e.getMessage());
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		 Task todo = new Task();
		 todo.setTask("Descricao");
		// todo.setDueDate(LocalDate.now());
		 //TaskController controller = new TaskController();     declarado como global, por isso comentado
		 try {
			controller.save(todo);
			Assert.fail("Não deveria ter chegado nesse ponto!"); //garante que o mock não esta afetando na validação do teste unitario
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the due date", e.getMessage());
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		 Task todo = new Task();
		 todo.setTask("Descricao");
		 todo.setDueDate(LocalDate.of(2010, 01, 01));
		// TaskController controller = new TaskController();     declarado como global, por isso comentado
		 try {
			controller.save(todo);
			Assert.fail("Não deveria ter chegado nesse ponto!"); //garante que o mock não esta afetando na validação do teste unitario
		} catch (ValidationException e) {
			Assert.assertEquals("Due date must not be in past", e.getMessage());
		}
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws ValidationException {
		 Task todo = new Task();
		 todo.setTask("Descricao");
		 todo.setDueDate(LocalDate.of(2030, 01, 01));
		// TaskController controller = new TaskController();     declarado como global, por isso comentado
		 controller.save(todo);
		 Mockito.verify(taskRepo).save(todo);
		 //verificacao se o mockito esta funcionando corretamente

		 
	}
	

}
