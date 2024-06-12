package Cap5.HeterogeneousContainer.Demo;

import Cap5.HeterogeneousContainer.Model.CompanyProperties;
import Cap5.HeterogeneousContainer.Model.PhoneNumber;
import Cap5.HeterogeneousContainer.PropertyMap;
import java.util.ArrayList;
import java.util.List;

public class CompanyCreation {

  List<PropertyMap> getCompanies() {

    List<PropertyMap> companies = new ArrayList<>();

    PropertyMap company = new PropertyMap();
    company.setProperty(CompanyProperties.RAZAO_SOCIAL, "Dell Technology");
    company.setProperty(CompanyProperties.PHONE_NUMBER, new PhoneNumber("55", "13", "3402-0329"));
    companies.add(company);

    PropertyMap company1 = new PropertyMap();
    company.setProperty(CompanyProperties.RAZAO_SOCIAL, "Dell Technology");
    company.setProperty(CompanyProperties.PHONE_NUMBER, new PhoneNumber("55", "13", "3402-0329"));
    companies.add(company1);

    return companies;
  }

}
