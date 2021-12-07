package com.example.praca_inzynierska;

import com.example.praca_inzynierska.Event;
import com.example.praca_inzynierska.EventDao;
import com.example.praca_inzynierska.UserDao;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;


public class EventFinallService {
    private final EventFinallDao eventFinallDao = new EventFinallDao();
    private final EventMapper eventMapper = new EventMapper();

    public void add(EventSaveRequest saveRequest) {
        Event eventToSave = eventMapper.map(saveRequest);
        eventFinallDao.save(eventToSave);
    }

    public List<EventBasicInfo> findAll() {
        return eventFinallDao.findAll()
                .stream().map(eventMapper::map)
                .collect(Collectors.toList());
    }

    public List<EventBasicInfo> findAllByCategory(int categoryId) {
        return eventFinallDao.findByCategory(categoryId)
                .stream().map(eventMapper::map)
                .collect(Collectors.toList());
    }

    private static class EventMapper {
        private final UserDao userDao = new UserDao();
        private final VoteFinallDao voteFinallDao = new VoteFinallDao();

        EventBasicInfo map(Event d) {
            return new EventBasicInfo(
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


        Event map(EventSaveRequest ds) {
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
