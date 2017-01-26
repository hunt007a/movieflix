package SandBoxTestRunnner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import io.training.backendapp.controller.test.MovieControllerTest;
import io.training.backendapp.entity.test.MovieEntityTest;
import io.training.backendapp.repository.test.MovieRepositoryTest;
import io.training.backendapp.service.test.MovieServiceTest;

@RunWith(Suite.class)
@SuiteClasses({MovieEntityTest.class, MovieControllerTest.class, MovieServiceTest.class, MovieRepositoryTest.class})
public class AllTests {

}
