
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import ru.alishev.springcourse.controllers.PeopleController;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class MockTest {
    PeopleController mockController = Mockito.mock(PeopleController.class);
    Person testPerson = new Person(1, "Name", 1995, new ArrayList<Book>());


    @Test
    public void peopleControllerCreteTest(){
        BindingResult mockBindingResult = Mockito.mock(BindingResult.class);

        assertThat(testPerson).isNotNull();
        mockController.create(testPerson, mockBindingResult);
        mockController.create(testPerson, mockBindingResult);

        Mockito.verify(mockController, Mockito.times(2))
                .create(testPerson, mockBindingResult);

    }

    @Test
    public void peopleControllerShowTest(){
        Model mockModel =  Mockito.mock(Model.class);
        Mockito.when(mockController.show(1, mockModel) ).thenThrow(new RuntimeException("Show Test"));
    }
}
