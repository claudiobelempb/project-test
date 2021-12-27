package br.com.surb.surb.modules.room.infra.jpa.repositories;

import br.com.surb.surb.modules.room.infra.jpa.entities.Room;
import br.com.surb.surb.shared.enums.TypeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  Optional<Room> findByIdAndStatus(Long id, TypeStatus status);
  Optional<Room> findByNameAndStatus(String name, TypeStatus status);
}
