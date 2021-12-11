package com.example.praca_inzynierska.event;

import com.example.praca_inzynierska.vote.VoteDao;
import com.example.praca_inzynierska.user.UserDao;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;


public class EventService {
    private final EventDao eventDao = new EventDao();
    private final EventMapper eventMapper = new EventMapper();

    public void add(EventSaveRequestDto saveRequest) {
        Event eventToSave = eventMapper.map(saveRequest);
        eventDao.save(eventToSave);
    }

    public List<EventBasicInfoDto> findAll() {
        return eventDao.findAll()
                .stream().map(eventMapper::map)
                .collect(Collectors.toList());
    }

    public List<EventBasicInfoDto> findAllByCategory(int categoryId) {
        return eventDao.findByCategory(categoryId)
                .stream().map(eventMapper::map)
                .collect(Collectors.toList());
    }

    private static class EventMapper {
        private final UserDao userDao = new UserDao();
        private final VoteDao voteDao = new VoteDao();

        EventBasicInfoDto map(Event d) {
            return new EventBasicInfoDto(
                    d.getId(),
                    d.getTeamA(),
                    d.getTeamB(),
                    d.getRate(),
                    d.getDateAdded(),
                    userDao.findById(d.getUserId()).orElseThrow().getUsername(),
                    voteDao.addScore(d.getId()),
                    voteDao.addPoints(d.getId()),
                    voteDao.addPoints(d.getId()),
                    voteDao.countTEAMA(d.getId()),
                    voteDao.countDRAW(d.getId()),
                    voteDao.countTEAMB(d.getId())
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
