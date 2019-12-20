package com.nmuzychuk.roomservice;

import com.nmuzychuk.roomcommon.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
