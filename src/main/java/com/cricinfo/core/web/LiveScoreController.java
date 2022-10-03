package com.cricinfo.core.web;

import com.cricinfo.core.datatables.DataTableRequest;
import com.cricinfo.core.datatables.DataTableResponse;
import com.cricinfo.core.domain.LiveScore;
import com.cricinfo.core.service.LiveScoreService;
import com.cricinfo.core.utils.DateTimeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/live-score")
@RequiredArgsConstructor
@Slf4j
public class LiveScoreController {

    private final LiveScoreService liveScoreService;

    @GetMapping("/list")
    public String showSettingPage(Model model) {
        model.addAttribute("menu", 1);
        return "live-score/list";
    }

    @RequestMapping(value = "/load-data", method = RequestMethod.POST)
    public @ResponseBody
    String loadBitrate(@RequestBody DataTableRequest datatableRequest) {
        try {
            ObjectMapper Obj = new ObjectMapper();
            DataTableResponse dataTableDTO = new DataTableResponse();
            List<LiveScore> dataList = liveScoreService.getList(datatableRequest);
            long totalRow = liveScoreService.getTotalRow(datatableRequest);
            if (dataList != null && !dataList.isEmpty()) {
                int index = 0;
                Object[] catData = new Object[dataList.size()];
                for (LiveScore liveScore : dataList) {
                    catData[index++] = liveScoreTableRowData(liveScore);
                }
                dataTableDTO.setData(catData);
                dataTableDTO.setRecordsTotal(totalRow);
                dataTableDTO.setRecordsFiltered(totalRow);
            } else {
                dataTableDTO.setData(new Object[0]);
                dataTableDTO.setRecordsTotal(0);
                dataTableDTO.setRecordsFiltered(0);
            }
            return Obj.writeValueAsString(dataTableDTO);

        } catch (Exception e) {
            log.error("EXCEPTION WHILE LOADING LIVE SCORE: {}", e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("empty-statement")
    private String[] liveScoreTableRowData(LiveScore liveScore) {
        String[] tData = new String[5];
        tData[0] = liveScore.getTitle();
        tData[1] = liveScore.getLink();
        tData[2] = liveScore.getDescription();
        tData[3] = liveScore.getGuid();
        tData[4] = DateTimeUtils.getDateString("yyyy-MM-dd HH:mm:ss", liveScore.getCreatedOn());
        return tData;
    }
}
