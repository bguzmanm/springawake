package cl.awakelab.m1spring.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
public class CountryEntity {
    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    private String country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<CityEntity> cities;


    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", cities=" + cities +
                '}';
    }
}
