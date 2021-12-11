package com.example.praca_inzynierska.vote;

import com.example.praca_inzynierska.user.User;
import com.example.praca_inzynierska.user.UserDao;

import java.time.LocalDateTime;
import java.util.Optional;

class EventVoteService {
    private VoteDao voteDao = new VoteDao();
    private EventVoteMapper voteMapper = new EventVoteMapper();

    public void addVote(EventVoteDto vote) {
        Vote voteToSave = voteMapper.map(vote);
        voteDao.save(voteToSave);
    }



    private static class EventVoteMapper {
        private final UserDao userDao = new UserDao();

        Vote map(EventVoteDto vote) {
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