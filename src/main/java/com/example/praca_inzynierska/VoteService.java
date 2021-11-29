package com.example.praca_inzynierska;

import com.example.praca_inzynierska.User;
import com.example.praca_inzynierska.UserDao;
import com.example.praca_inzynierska.Vote;
import com.example.praca_inzynierska.VoteDao;

import java.time.LocalDateTime;
import java.util.Optional;

class EventVoteService {
    private VoteDao voteDao = new VoteDao();
    private EventVoteMapper voteMapper = new EventVoteMapper();

    public void addVote(EventVote vote) {
        Vote voteToSave = voteMapper.map(vote);
        voteDao.save(voteToSave);
    }

    private static class EventVoteMapper {
        private final UserDao userDao = new UserDao();

        Vote map(EventVote vote) {
            Optional<User> user = userDao.findByUsername(vote.getUsername());
            return new Vote(
                    user.orElseThrow().getId(),
                    vote.getEventId(),
                    Vote.Type.valueOf(vote.getType()),
                    LocalDateTime.now()
            );
        }
    }
}