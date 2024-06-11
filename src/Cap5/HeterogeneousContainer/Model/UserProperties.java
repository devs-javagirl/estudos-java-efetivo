package Cap5.HeterogeneousContainer.Model;

import Cap5.HeterogeneousContainer.Property;
import java.time.LocalDate;

public class UserProperties {
  public static final Property<String> NAME = new Property<>("Name", String.class);
  public static final Property<Integer> AGE = new Property<>("Age", Integer.class);
  public static final Property<LocalDate> BIRTHDAY = new Property<>("Birthday", LocalDate.class);

  public static final Property<PhoneNumber> PHONE_NUMBER = new Property<>("Phone Number", PhoneNumber.class);

  private UserProperties(){}
}
