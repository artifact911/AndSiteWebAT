package com.andersenlab.autotests.core.utils.testrail;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
class TestRailApi {
    private static final String SERVER = PropertiesReader.get("testRail.api.url");
    private static final String LOGIN = PropertiesReader.get("testRail.login");
    private static final String PASSWORD = PropertiesReader.get("testRail.password");
    private TestRailHttpClient client;

    TestRailApi() {
        client = new TestRailHttpClient(SERVER, LOGIN, PASSWORD);
    }

    void addResultWithComment(TestRailStatus statusData, String comment, String runId, String id) {
        String addResult = "add_result_for_case/";
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("status_id", statusData.getId());
            data.put("comment", "Autotest: " + comment);
            JSONObject response = (JSONObject) client.sendPost(addResult + runId + "/" + id, data);
        } catch (Exception e) {
            log.error(String.format("Не удалось отправить результаты по кейсу %s. Возникла ошибка: %s", id, e));
            return;
        }
        log.info("Результаты теста " + id + " отправлены в TestRail, результат: " + statusData.getComment());
    }

    void addResultWithCommentAndAttachment(TestRailStatus statusData, String comment, String runId, String id, Object attachment) {
        String addResult = "add_result_for_case/";
        String addAttachment = "add_attachment_to_result/";
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("status_id", statusData.getId());
            data.put("comment", "Autotest: " + comment);
            JSONObject response = (JSONObject) client.sendPost(addResult + runId + "/" + id, data);
            client.sendPost(addAttachment + response.get("id"), attachment);
        } catch (Exception e) {
            log.error(String.format("Не удалось отправить результаты по кейсу %s. Возникла ошибка: %s", id, e));
            return;
        }
        log.info("Результаты теста " + id + " отправлены в TestRail, результат: " + statusData.getComment());
    }

    void addResultWithBug(String bug, String comment, String runId, String id) {
        String addResult = "add_result_for_case/";
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("status_id", TestRailStatus.BUG.getId());
            data.put("defects", bug);
            data.put("comment", comment);
            client.sendPost(addResult + runId + "/" + id, data);
        } catch (Exception e) {
            log.error(String.format("Не удалось отправить результаты по кейсу %s. Возникла ошибка: %s", id, e));
            return;
        }
        log.info("Результаты теста отправлены в TestRail");
    }

    List<String> getTestCaseIdsFromTestRun(String runId) {
        String getCase = "get_tests/";
        List<String> tests = new ArrayList<>();
        try {
            List<JSONObject> testsInRun = (List<JSONObject>) client.sendGet(getCase + runId);
            testsInRun.stream().filter(test -> !test.get("case_id").toString().isEmpty()).forEach(test -> tests.add(test.get("case_id").toString()));
        } catch (Exception e) {
            log.error(String.format("Не удалось получить id тестов в ране %s. Возникла ошибка: %s", runId, e));
        }
        log.info(String.format("Получены id тестов из рана %s", runId));
        log.info(String.format("Количество тестов в тестране %d", tests.size()));
        return tests;
    }
}
