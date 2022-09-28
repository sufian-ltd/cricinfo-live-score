package com.cricinfo.core.service.implementation;

import com.cricinfo.core.datatables.DataOrder;
import com.cricinfo.core.datatables.DataTableRequest;
import com.cricinfo.core.domain.LiveScore;
import com.cricinfo.core.repository.LiveScoreRepository;
import com.cricinfo.core.service.LiveScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LiveScoreServiceImpl implements LiveScoreService {

    private final LiveScoreRepository liveScoreRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<LiveScore> getByTitle(String title) {
        return liveScoreRepository.findByTitle(title);
    }

    @Override
    public LiveScore save(LiveScore liveScore) {
        return liveScoreRepository.save(liveScore);
    }

    @Override
    public List<LiveScore> getList(DataTableRequest dataTableRequest) {
        String orderBy = "ls.created_on desc";
        String[] orderColumns = {"ls.title", "ls.link", "ls.description", "ls.guid", "ls.created_on"};
        if (dataTableRequest.getOrder() != null && dataTableRequest.getOrder().size() > 0) {
            DataOrder order = dataTableRequest.getOrder().get(0);
            orderBy = orderColumns[order.getColumn()] + " " + order.getDir();
        }

        String condition = queryCondition(dataTableRequest);
        String sql = "select * from live_score as ls" + " WHERE " + condition + " ORDER BY " + orderBy + " limit " + dataTableRequest.getLength() + " offset " + dataTableRequest.getStart();
        Query query = entityManager.createNativeQuery(sql, LiveScore.class);
        return query.getResultList();
    }

    @Override
    public long getTotalRow(DataTableRequest dataTableRequest) {
        String condition = queryCondition(dataTableRequest);
        String sql = "select count(ls.id) from live_score as ls" + " WHERE " + condition;
        Query query = entityManager.createNativeQuery(sql);
        BigInteger result = (BigInteger) query.getSingleResult();
        return result.longValue();
    }

    private String queryCondition(DataTableRequest dataTableRequest) {
        String[] searchColumns = {"title", "link", "description", "guid", "created_on"};

        String condition = null;

        if (dataTableRequest.getSearch() != null && dataTableRequest.getSearch().getValue() != null && !dataTableRequest.getSearch().getValue().isEmpty()) {
            int i = 0;
            String searchValue = dataTableRequest.getSearch().getValue();
            for (String column : searchColumns) {
                if (i > 0) {
                    condition += " OR ";
                } else {
                    condition = "(";
                }
                condition += column + " like '%" + searchValue + "%'";
                i++;
                if (i == searchColumns.length) {
                    condition += ")";
                }
            }
        } else {
            condition = "ls.id>0";
        }
        return condition;
    }
}
