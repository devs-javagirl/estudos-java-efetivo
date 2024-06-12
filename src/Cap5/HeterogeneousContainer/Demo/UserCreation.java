package Cap5.HeterogeneousContainer.Demo;

import Cap5.HeterogeneousContainer.Model.PhoneNumber;
import Cap5.HeterogeneousContainer.Model.UserProperties;
import Cap5.HeterogeneousContainer.PropertyMap;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserCreation {

  public List<PropertyMap> getUsers(){
    List<PropertyMap> users = new ArrayList<>();

    PropertyMap user = new PropertyMap();
    user.setProperty(UserProperties.NAME, "Catarina");
    user.setProperty(UserProperties.AGE, 34);
    user.setProperty(UserProperties.BIRTHDAY, LocalDate.of(1980, 5, 26));
    user.setProperty(UserProperties.PHONE_NUMBER, new PhoneNumber("55", "11", "98304-9430"));
    users.add(user);

    PropertyMap user1 = new PropertyMap();
    user1.setProperty(UserProperties.NAME, "Amelia");
    user1.setProperty(UserProperties.AGE, 24);
    user1.setProperty(UserProperties.BIRTHDAY, LocalDate.of(2000, 5, 3));
    user1.setProperty(UserProperties.PHONE_NUMBER, new PhoneNumber("55", "11", "9810-3022"));
    users.add(user1);

    return users;

  }



}
