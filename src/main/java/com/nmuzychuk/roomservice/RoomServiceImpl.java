package com.nmuzychuk.roomservice;

import com.nmuzychuk.roomcommon.Room;
import com.nmuzychuk.roomcommon.RoomService;
import com.nmuzychuk.roomcommon.RoomState;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class RoomServiceImpl implements RoomService {

    final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room addRoom() {
        return roomRepository.save(new Room());
    }

    @Override
    public Room findRoom(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public void dirtyRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        room.ifPresent(r -> r.setState(RoomState.DIRTY));

    }

    @Override
    public void cleanRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        room.ifPresent(r -> r.setState(RoomState.CLEAN));
    }
}
