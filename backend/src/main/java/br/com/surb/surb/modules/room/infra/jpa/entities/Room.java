package br.com.surb.surb.modules.room.infra.jpa.entities;

import br.com.surb.surb.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_room")
public class Room implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer seats;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  public Room(){}

  private Room(Long id, String name, Integer seats, TypeStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.seats = seats;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Room(RoomBuilder roomBuilder){
    id = roomBuilder.id;
    name = roomBuilder.name;
    seats = roomBuilder.seats;
    status = roomBuilder.status;
    createdAt = roomBuilder.createdAt;
    updatedAt = roomBuilder.updatedAt;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getSeats() {
    return seats;
  }

  public TypeStatus getStatus() {
    return status;
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
    if(Objects.isNull(status)){
      status = TypeStatus.ENABLED;
    }
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Room role = (Room) o;
    return id.equals(role.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public static RoomBuilder newBuilder() {
    return new RoomBuilder();
  }

  public static final class RoomBuilder {
    private Long id;
    private String name;
    private Integer seats;
    private TypeStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    private RoomBuilder() {
    }

    public RoomBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public RoomBuilder name(String name) {
      this.name = name;
      return this;
    }

    public RoomBuilder seats(Integer seats) {
      this.seats = seats;
      return this;
    }

    public RoomBuilder status(TypeStatus status) {
      this.status = status;
      return this;
    }

    public RoomBuilder createdAt(Instant createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public RoomBuilder updatedAt(Instant updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Room build() {
      return new Room(this);
    }
  }
}
