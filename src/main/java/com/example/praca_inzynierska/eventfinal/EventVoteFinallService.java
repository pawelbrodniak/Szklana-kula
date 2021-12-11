package com.example.praca_inzynierska.eventfinal;

import com.example.praca_inzynierska.vote.VoteFinall;
import com.example.praca_inzynierska.vote.VoteFinallDao;
import com.example.praca_inzynierska.user.User;
import com.example.praca_inzynierska.user.UserDao;

import java.time.LocalDateTime;
import java.util.Optional;

class EventVoteFinallService {
    private VoteFinallDao votefinallDao = new VoteFinallDao();
    private EventVoteFinallMapper votefinallMapper = new EventVoteFinallMapper();

    public void addVoteFinall(EventVoteFinallDto votefinall) {
        VoteFinall votefinallToSave = votefinallMapper.map(votefinall);
        votefinallDao.save(votefinallToSave);
    }



    private static class EventVoteFinallMapper {
        private final UserDao userDao = new UserDao();

        VoteFinall map(EventVoteFinallDto votefinall) {
            Optional<User> user = userDao.findByUsername(votefinall.getUsername());
            return new VoteFinall(
                    user.orElseThrow().getId(),
                    votefinall.getEventId(),
                    VoteFinall.Type.valueOf(votefinall.getType()),
                    LocalDateTime.now()
            );
        }
    }
}