package Cap5.HeterogeneousContainer.Model;

import Cap5.HeterogeneousContainer.Property;
import java.time.LocalDate;

public class UserProperties {
  public static final Property<String> NAME = new Property<>("Nome", String.class);
  public static final Property<Integer> AGE = new Property<>("Idade", Integer.class);
  public static final Property<LocalDate> BIRTHDAY = new Property<>("Data de Nascimento", LocalDate.class);

  public static final Property<PhoneNumber> PHONE_NUMBER = new Property<>("Telefone", PhoneNumber.class);

  private UserProperties(){}
}
