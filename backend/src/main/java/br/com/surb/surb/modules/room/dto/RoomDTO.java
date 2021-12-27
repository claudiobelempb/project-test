package br.com.surb.surb.modules.room.dto;

import br.com.surb.surb.modules.room.infra.jpa.entities.Room;
import br.com.surb.surb.shared.enums.TypeStatus;

import java.io.Serializable;
import java.time.Instant;

public class RoomDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Integer seats;
  private TypeStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  public RoomDTO(Long id, String name, Integer seats, TypeStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.seats = seats;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public RoomDTO(Room room){
    id = room.getId();
    name = room.getName();
    seats = room.getSeats();
    status = room.getStatus();
    createdAt = room.getCreatedAt();
    updatedAt = room.getUpdatedAt();

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

  public Integer getSeats() {
    return seats;
  }

  public void setSeats(Integer seats) {
    this.seats = seats;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
