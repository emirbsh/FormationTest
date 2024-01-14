package testsLogin;


import org.testng.TestNG;

public class Main {

    public static void main(String[] args) {
        // Créer un objet TestNG
        TestNG testNG = new TestNG();

        // Ajouter les classes de test
        testNG.setTestClasses(new Class[]{LoginFailTest.class, LoginSuccessTest.class});

        // Exécuter les tests
        testNG.run();
    }
}
