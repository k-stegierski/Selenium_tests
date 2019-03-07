import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

public interface Fake_data {
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
    String email = fakeValuesService.bothify("???###@mail.com");
    Faker faker = new Faker();
    String firstname = faker.name().name();
    String surname = faker.name().lastName();
    String birthday = LocalDateTime.ofInstant(faker.date().birthday(18,55).toInstant(), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    String address = faker.address().streetAddress();
    String address_2nd_line = faker.address().secondaryAddress();
    String company = faker.company().name();
    String city = faker.address().city();
    String state = faker.address().state();
    String zipcode = faker.address().zipCode();
    String additional_info = "Best automated test ! :)";
    String homephone = faker.phoneNumber().phoneNumber().subSequence(0,12).toString();
    String mobile = faker.phoneNumber().cellPhone();
//    String alias = UUID.randomUUID().toString().substring(0,32);
    String alias = "Address";
}
