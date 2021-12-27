package br.com.surb.surb.modules.user.dto;

import br.com.surb.surb.modules.role.dto.RoleCreateDTO;
import br.com.surb.surb.modules.user.infra.jps.entities.User;
import br.com.surb.surb.shared.enums.TypeStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Instant updatedAt;
  private TypeStatus status;

  private final Set<RoleCreateDTO> roles = new HashSet<>();

  public UserUpdateDTO(){}

  public UserUpdateDTO(Long id, String firstName, String lastName, String email,
                       Instant updatedAt,
                       TypeStatus status) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public UserUpdateDTO(User user){
    id = user.getId();
    firstName = user.getFirstName();
    lastName = user.getLastName();
    email = user.getEmail();
    updatedAt = user.getUpdatedAt();
    status = user.getStatus();
    user.getRoles().forEach(role -> this.roles.add(new RoleCreateDTO(role)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public Set<RoleCreateDTO> getRoles() {
    return roles;
  }
}
