package June25th_Class_API;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab133 {

    Faker faker = new Faker();
    String name = faker.name().fullName();
    String password = faker.internet().password();

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{name, password},
                new Object[]{"admin", "admin"},
                new Object[]{"amin122", "admin123"}
        };
    }

    @Test(dataProvider = "getData")
    public void getUserDetails(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }
}
