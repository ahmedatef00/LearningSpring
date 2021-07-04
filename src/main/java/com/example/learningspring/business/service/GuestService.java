package com.example.learningspring.business.service;


import com.example.learningspring.business.domain.RoomGuest;
import com.example.learningspring.data.entity.Guest;
import com.example.learningspring.data.repository.GuestRepository;
import com.example.learningspring.data.repository.ReservationRepository;
import com.example.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//business logic
@Service
public class GuestService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public GuestService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomGuest> getAllGuests() {
        Iterable<Guest> guestList = guestRepository.findAll();
        Map<Long, RoomGuest> guestMap=new HashMap<Long, RoomGuest>();

        guestList.forEach((guest -> {
            RoomGuest roomGuest =new RoomGuest();
            roomGuest.setFirstName(guest.getFirstName());
            roomGuest.setGuestId(guest.getGuestId());
            roomGuest.setLastName(guest.getLastName());
            roomGuest.setAddress(guest.getAddress());
            roomGuest.setCountry(guest.getCountry());
            roomGuest.setEmailAddress(guest.getEmailAddress());
            roomGuest.setState(guest.getState());
            roomGuest.setPhoneNumber(guest.getPhoneNumber());
            guestMap.put(guest.getGuestId(),roomGuest);
        }));
        List <RoomGuest> roomGuests=new ArrayList<>();
        for (Long id:guestMap.keySet()){

            roomGuests.add(guestMap.get(id));
        }
        roomGuests.sort(new Comparator<RoomGuest>() {
            @Override
            public int compare(RoomGuest o1, RoomGuest o2) {
                if (o1.getLastName()==o2.getLastName()){
                    return  o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
                }
                return  o1.getLastName().compareToIgnoreCase(o2.getLastName());
            }
        });

        return roomGuests;

    }

}
