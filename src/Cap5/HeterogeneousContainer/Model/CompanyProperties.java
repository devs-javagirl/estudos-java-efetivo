package Cap5.HeterogeneousContainer.Model;


import Cap5.HeterogeneousContainer.Property;

public class CompanyProperties {
  public static final Property<String> COMPANY_NAME = new Property<>("Razão Social", String.class);
  public static final Property<PhoneNumber> PHONE_NUMBER = new Property<>("Telefone", PhoneNumber.class);

}
