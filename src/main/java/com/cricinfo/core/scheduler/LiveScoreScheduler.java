package com.cricinfo.core.scheduler;

import com.cricinfo.core.service.LiveScoreService;
import com.cricinfo.core.domain.LiveScore;
import com.cricinfo.core.xml.model.LiveScoreXML;
import com.cricinfo.core.utils.XmlUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class LiveScoreScheduler {

    @Value("${url.live_score}")
    private String liveScoreUrl;

    private final RestTemplate restTemplate;
    private final LiveScoreService liveScoreService;

    @Scheduled(fixedRateString = "${scheduler.interval.fetch_live_score}")
    public void fetchingLiveScores() {
        log.info("START FETCHING LIVE SCORE FROM :{}, TIME: {}", liveScoreUrl, new Date());
        ResponseEntity<String> scoresResponse = restTemplate.getForEntity(liveScoreUrl, String.class);
        if (scoresResponse.getStatusCode().equals(HttpStatus.OK) && scoresResponse.hasBody()) {
            LiveScoreXML liveScoreXML = XmlUtils.toObject(scoresResponse.getBody(), LiveScoreXML.class);

            for (LiveScoreXML.Channel.Item item : liveScoreXML.getChannel().getItem()) {
                String title = item.getTitle().trim().replace("*", "");
                Optional<LiveScore> existLiveScore = liveScoreService.getByTitle(title);
                if (!existLiveScore.isPresent()) {
                    LiveScore liveScore = new LiveScore();
                    liveScore.setTitle(title);
                    liveScore.setLink(item.getLink().trim());
                    liveScore.setDescription(item.getDescription().trim());
                    liveScore.setGuid(item.getGuid().trim());
                    liveScoreService.save(liveScore);
                    log.info("NEW LIVE SCORE RECORD SAVED: {}", liveScore);
                }
            }
        }
    }
}
