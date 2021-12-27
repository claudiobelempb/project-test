package br.com.surb.surb.modules.address.country.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_country")
public class Country implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String name_pt;
  private String abbreviation;
  private Integer bacen;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  public Country(){}

  public Country(Long id, String name, String name_pt, String abbreviation, Integer bacen) {
    this.id = id;
    this.name = name;
    this.name_pt = name_pt;
    this.abbreviation = abbreviation;
    this.bacen = bacen;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName_pt() {
    return name_pt;
  }

  public void setName_pt(String name_pt) {
    this.name_pt = name_pt;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public Integer getBacen() {
    return bacen;
  }

  public void setBacen(Integer bacen) {
    this.bacen = bacen;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  @PrePersist
  public void prePersist(){
    createdAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Country country = (Country) o;
    return id.equals(country.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
