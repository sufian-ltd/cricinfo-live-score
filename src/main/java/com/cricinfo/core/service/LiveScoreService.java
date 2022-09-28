package com.cricinfo.core.service;

import com.cricinfo.core.datatables.DataTableRequest;
import com.cricinfo.core.domain.LiveScore;

import java.util.List;
import java.util.Optional;

public interface LiveScoreService {

    Optional<LiveScore> getByTitle(String title);

    LiveScore save(LiveScore liveScore);

    List<LiveScore> getList(DataTableRequest dataTableRequest);

    long getTotalRow(DataTableRequest dataTableRequest);
}
