package br.com.surb.surb.modules.allocation.infra.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_allocations")
public class Allocation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String subject;
  private Boolean active;
//  private Room room;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private OffsetDateTime startAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private OffsetDateTime endAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  public Allocation(){}

  private Allocation(AllocationBuilder allocationBuilder) {
    id = allocationBuilder.id;
    subject = allocationBuilder.subject;
    active = allocationBuilder.active;
    startAt = allocationBuilder.startAt;
    endAt = allocationBuilder.endAt;
    createdAt = allocationBuilder.createdAt;
    updatedAt = allocationBuilder.updatedAt;
  }

  public Long getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public OffsetDateTime getStartAt() {
    return startAt;
  }

  public OffsetDateTime getEndAt() {
    return endAt;
  }

  public Boolean getActive() {
    return active;
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
    active = true;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Allocation role = (Allocation) o;
    return id.equals(role.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public static final class AllocationBuilder {
    private Long id;
    private String subject;
    private Boolean active;
    private OffsetDateTime startAt;
    private OffsetDateTime endAt;
    private Instant createdAt;
    private Instant updatedAt;

    private AllocationBuilder() {
    }

    public static AllocationBuilder anAllocation() {
      return new AllocationBuilder();
    }

    public AllocationBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public AllocationBuilder withSubject(String subject) {
      this.subject = subject;
      return this;
    }

    public AllocationBuilder withActive(Boolean active) {
      this.active = active;
      return this;
    }

    public AllocationBuilder withStartAt(OffsetDateTime startAt) {
      this.startAt = startAt;
      return this;
    }

    public AllocationBuilder withEndAt(OffsetDateTime endAt) {
      this.endAt = endAt;
      return this;
    }

    public AllocationBuilder withCreatedAt(Instant createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public AllocationBuilder withUpdatedAt(Instant updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Allocation build() {
      return new Allocation(this);
    }
  }
}
