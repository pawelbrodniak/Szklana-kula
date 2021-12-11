package com.example.praca_inzynierska.eventfinal;

import com.example.praca_inzynierska.vote.VoteFinallDao;
import com.example.praca_inzynierska.event.Event;
import com.example.praca_inzynierska.event.EventBasicInfoDto;
import com.example.praca_inzynierska.event.EventSaveRequestDto;
import com.example.praca_inzynierska.user.UserDao;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;


public class EventFinallService {
    private final EventFinallDao eventFinallDao = new EventFinallDao();
    private final EventMapper eventMapper = new EventMapper();

    public void add(EventSaveRequestDto saveRequest) {
        Event eventToSave = eventMapper.map(saveRequest);
        eventFinallDao.save(eventToSave);
    }

    public List<EventBasicInfoDto> findAll() {
        return eventFinallDao.findAll()
                .stream().map(eventMapper::map)
                .collect(Collectors.toList());
    }

    public List<EventBasicInfoDto> findAllByCategory(int categoryId) {
        return eventFinallDao.findByCategory(categoryId)
                .stream().map(eventMapper::map)
                .collect(Collectors.toList());
    }

    private static class EventMapper {
        private final UserDao userDao = new UserDao();
        private final VoteFinallDao voteFinallDao = new VoteFinallDao();

        EventBasicInfoDto map(Event d) {
            return new EventBasicInfoDto(
                    d.getId(),
                    d.getTeamA(),
                    d.getTeamB(),
                    d.getRate(),
                    d.getDateAdded(),
                    userDao.findById(d.getUserId()).orElseThrow().getUsername(),
                    voteFinallDao.addScore(d.getId()),
                    voteFinallDao.addScore0(d.getId()),
                    voteFinallDao.addPoints(d.getId()),
                    voteFinallDao.countTEAMA(d.getId()),
                    voteFinallDao.countDRAW(d.getId()),
                    voteFinallDao.countTEAMB(d.getId())
            );
        }


        Event map(EventSaveRequestDto ds) {
            return new Event(
                    ds.getTeamA(),
                    ds.getTeamB(),
                    ds.getRate(),
                    LocalDateTime.now(),
                    ds.getCategoryId(),
                    userDao.findByUsername(ds.getAuthor())
                            .orElseThrow()
                            .getId()
            );
        }
    }
}
