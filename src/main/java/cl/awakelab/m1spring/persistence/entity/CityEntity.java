package cl.awakelab.m1spring.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="city")
public class CityEntity {
    @Id
    @Column(name="city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    private String city;
    @Column(name="country_id")
    private Integer countryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private CountryEntity countryEntity;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public CountryEntity getCountry() {
        return countryEntity;
    }

    public void setCountry(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", country=" + countryEntity +
                '}';
    }
}
