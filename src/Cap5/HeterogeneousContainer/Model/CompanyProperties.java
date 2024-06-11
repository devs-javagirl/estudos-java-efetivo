package Cap5.HeterogeneousContainer.Model;


import Cap5.HeterogeneousContainer.Property;

public class CompanyProperties {
  public static final Property<String> RAZAO_SOCIAL = new Property<>("Razão Social", String.class);
  public static final Property<PhoneNumber> PHONE_NUMBER = new Property<>("Phone Number", PhoneNumber.class);

}
