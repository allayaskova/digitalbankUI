package ui.Utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MockData {
    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),new RandomService());

    public Map<String, String> generateRandomNameAndEmail() {
        String name = fakeValuesService.bothify(new Faker().name().firstName());
        String email = fakeValuesService.bothify(name + "###@email.com");

        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("email", email);
        return data;
    }


        public String generateRandomSSN(){
            String ssn = String.format("%09d", new Random().nextInt(1000000000));
            return ssn;
        }

////just to test how it will look. Should give email with the same name as provided plus 3 digits
//    public static void main(String[] args) {
//        MockData mockData = new MockData();
//        Map<String, String> data = mockData.generateRandomNameAndEmail();
//        System.out.println(data.get("name"));
//        System.out.println(data.get("email"));
//    }
    }

