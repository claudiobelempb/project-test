package br.com.surb.surb.modules.allocation.dto;

import br.com.surb.surb.modules.allocation.infra.jpa.entities.Allocation;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;

public class AllocationDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String subject;
  private Boolean active;
  private OffsetDateTime startAt;
  private OffsetDateTime endAt;
  private Instant createdAt;
  private Instant updatedAt;

  public AllocationDTO(){}

  public AllocationDTO(Long id, String subject, Boolean active, OffsetDateTime startAt, OffsetDateTime endAt,
                       Instant createdAt,
                       Instant updatedAt) {
    this.id = id;
    this.subject = subject;
    this.active = active;
    this.startAt = startAt;
    this.endAt = endAt;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public AllocationDTO(Allocation allocation){
    id = allocation.getId();
    subject = allocation.getSubject();
    active = allocation.getActive();
    startAt = allocation.getStartAt();
    endAt = allocation.getEndAt();
    createdAt = allocation.getCreatedAt();
    updatedAt = allocation.getUpdatedAt();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public OffsetDateTime getStartAt() {
    return startAt;
  }

  public void setStartAt(OffsetDateTime startAt) {
    this.startAt = startAt;
  }

  public OffsetDateTime getEndAt() {
    return endAt;
  }

  public void setEndAt(OffsetDateTime endAt) {
    this.endAt = endAt;
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
