package com.example.praca_inzynierska;

import com.example.praca_inzynierska.User;
import com.example.praca_inzynierska.UserDao;
import com.example.praca_inzynierska.VoteFinall;
import com.example.praca_inzynierska.VoteFinallDao;

import java.time.LocalDateTime;
import java.util.Optional;

class EventVoteFinallService {
    private VoteFinallDao votefinallDao = new VoteFinallDao();
    private EventVoteFinallMapper votefinallMapper = new EventVoteFinallMapper();

    public void addVoteFinall(EventVoteFinall votefinall) {
        VoteFinall votefinallToSave = votefinallMapper.map(votefinall);
        votefinallDao.save(votefinallToSave);
    }



    private static class EventVoteFinallMapper {
        private final UserDao userDao = new UserDao();

        VoteFinall map(EventVoteFinall votefinall) {
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