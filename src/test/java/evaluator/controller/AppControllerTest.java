package evaluator.controller;

import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import evaluator.model.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    @org.junit.jupiter.api.Test
    void createNewTest() {

        AppController appController = new AppController();

        try {

            appController.addNewIntrebari(Arrays.asList(new Intrebare("Enunt1?", "1)var1.1", "2)var2.1", "1", "Domeniu1"),
                    new Intrebare("Enunt2?", "1)var1.2", "2)var2.2", "2", "Domeniu2"),
                    new Intrebare("Enunt3?", "1)var1.3", "2)var2.3", "3", "Domeniu3"),
                    new Intrebare("Enunt4?", "1)var1.4", "2)var2.4", "1", "Domeniu4"),
                    new Intrebare("Enunt5?", "1)var1.5", "2)var2.5", "2", "Domeniu5"),
                    new Intrebare("Enunt6?", "1)var1.6", "2)var2.6", "3", "Domeniu6"),
                    new Intrebare("Enunt7?", "1)var1.7", "2)var2.7", "1", "Domeniu7")));

            Test test = appController.createNewTest();


            Intrebare intrebare8 = new Intrebare("Enunt8?", "1)var1.1", "2)var2.1", "1", "Domeniu1");

            test = appController.createNewTest();


            appController.addNewIntrebare(intrebare8);
            appController.exists(intrebare8);
            appController.getStatistica();
            appController.loadIntrebariFromFile("C:\\Workspace\\Facultate\\ProiectEvaluatorExamen\\file.txt");


        } catch (InputValidationFailedException e) {
            e.printStackTrace();
            System.out.println("Intreabrea nu e corecta");
        } catch (DuplicateIntrebareException e) {
            e.printStackTrace();
            System.out.println("Intrebare duplicata, nu s-a adaugat");
        } catch (NotAbleToCreateTestException e) {
            e.printStackTrace();
            System.out.println("Nu se poate crea testul");
        } catch (NotAbleToCreateStatisticsException e) {
            e.printStackTrace();
        }

        System.out.println("Test creat");
    }

    @org.junit.jupiter.api.Test()
    public void errorInputValidationFailedExceptionTest() {

        assertThrows(InputValidationFailedException.class, () -> {
            AppController appController = new AppController();

            Intrebare intrebare9 = null;
            intrebare9 = new Intrebare("enunt1?", "1)var1.1", "2)var2.1", "1", "Domeniu1");


            appController = new AppController();

            appController.addNewIntrebare(intrebare9);

            Test test = appController.createNewTest();
        });

    }

    @org.junit.jupiter.api.Test()
    public void errorNotAbleToCreateTestExceptionTest() {

        assertThrows(NotAbleToCreateTestException.class, () -> {
            AppController appController = new AppController();

            Intrebare intrebare9 = null;
            intrebare9 = new Intrebare("Enunt1?", "1)var1.1", "2)var2.1", "1", "Domeniu1");


            appController = new AppController();

            appController.addNewIntrebare(intrebare9);

            Test test = appController.createNewTest();
        });

    }

    @org.junit.jupiter.api.Test()
    public void errorNotAbleToCreateTestExceptionTest2() {

        assertThrows(NotAbleToCreateTestException.class, () -> {
            AppController appController = new AppController();

            appController.addNewIntrebari(Arrays.asList(new Intrebare("Enunt1?", "1)var1.1", "2)var2.1", "1", "Domeniu1"),
                    new Intrebare("Enunt2?", "1)var1.2", "2)var2.2", "2", "Domeniu2"),
                    new Intrebare("Enunt3?", "1)var1.3", "2)var2.3", "3", "Domeniu3"),
                    new Intrebare("Enunt4?", "1)var1.4", "2)var2.4", "1", "Domeniu3"),
                    new Intrebare("Enunt5?", "1)var1.5", "2)var2.5", "2", "Domeniu2"),
                    new Intrebare("Enunt6?", "1)var1.6", "2)var2.6", "3", "Domeniu1"),
                    new Intrebare("Enunt7?", "1)var1.7", "2)var2.7", "1", "Domeniu2")));

            Test test = appController.createNewTest();
        });

    }

    @org.junit.jupiter.api.Test()
    public void errorNotAbleToCreateStatisticsExceptionTest() {

        assertThrows(NotAbleToCreateStatisticsException.class, () -> {
            AppController appController = new AppController();

            appController = new AppController();

            appController.getStatistica();
        });

    }

    @org.junit.jupiter.api.Test()
    public void errorDuplicateIntrebareExceptionTest() {

        assertThrows(DuplicateIntrebareException.class, () -> {
            AppController appController = new AppController();
            Intrebare intrebare9 = null;
            intrebare9 = new Intrebare("Enunt1?", "1)var1.1", "2)var2.1", "1", "Domeniu1");


            appController = new AppController();

            appController.addNewIntrebare(intrebare9);
            appController.addNewIntrebare(intrebare9);

        });

    }

}